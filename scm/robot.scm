 #lang racket
(require "map.scm")

     

(define (create-robot name)
  (let* (
        (position (cons 0 8)) ;; Start in upper corner in red area
        (direction 0) ; 0->E, 1->S, 2->W, 3->N
        (hasObject #f)
        
        (log (lambda (t)
              (with-output-to-file "/Users/ragnar/school/15-2-TIPLPA/project/pholst-gui/plpa-coursework/log.txt" (lambda () (
                                                        
                  ; Log file structure:
                  ; PC, X, Y, DIRECTION
                  printf (string-append 
                          (if (number? t)
                            (number->string t)
                            t) ","
                            
                          (number->string (car position)) ","
                          (number->string (cdr position)) ","
                          (number->string direction)
                          "\n"))) #:exists 'truncate)
               ))

        (lastDirection (cons 0 0))

        
        (turn-left (lambda (n) 
                      (begin
                        (set! direction (modulo (- n direction) 4))
                        (log 0)
                        )))
        (turn-right (lambda (n) 
                     (begin 
                       (set! direction (modulo (+ n direction) 4))
                       (log 9)
                       )))
        
        (move-up (lambda ()
                   (set! position (cons (car position) (- 1 (cdr position))))
                 position))
        
        (move-right (lambda () 
                   (set! position (cons (+ 1 (car position)) (cdr position)))
                 position))
        
              
        (move-down (lambda () 
                    (set! position (cons (car position) (+ 1 (cdr position))))
                    position)) 

            
        (move-left (lambda () 
                     (set! position (cons (- 1 (car position)) (cdr position)))
                     position))

        (move-forward (lambda (number_of_steps)
                        (begin
                          
                            ;(display (getTile (car position) (cdr position) floor))
                          
                            (if (= direction 0) (move-up) ; Does not work as expected
                            (if (= direction 1) (move-right) ; Seems to work
                                (if (= direction 2) (move-down) ; Seems to work
                                    (if (= direction 3) (move-left) 'UnknownDirection)))) ; Not tested
                            (sleep 1)
                            (log (number->string number_of_steps))
                            (newline)
                         

                            )))
        
        (pick-object (lambda(object_id) 
                       (if (eq? #t hasObject) 
                           (string-append "The robot already holds object " hasObject ". Please drop it first")
                           (begin 
                             (set! hasObject object_id)
                             (string-append "The robot did not have an object. Picking up: " object_id))
                        )))
        
        (drop-object (lambda(object_id)
                      (if (eq? hasObject object_id) 
                          (begin
                            (string-append "The robot has object " object_id ". Dropping at " (number->string (car position)) ", " (number->string (cdr position)))
                          )
                          (string-append "The robot cannot drop a object it does not hold."))))
                   
        )
    ; Expose methods from robot
    (list name 
          (cons 'position position)
          (cons 'direction direction)
          (cons 'pick-object pick-object)
          (cons 'drop-object drop-object)
          (cons 'log log)
          (cons 'move-left move-left)
          (cons 'move-forward move-forward)
          (cons 'turn-left  turn-left)
          (cons 'turn-right turn-right) )))
   
(define (get-from-robot r name)
  (cdr (assq name (cdr r))))

(define android (create-robot "android"))


(define (recurse fn n)
  (if (= n 0)
      null
      (begin
        (fn n)
        (recurse fn (- n 1)))))

; Mappings from our dsl -> robot
(define MOVE_FORWARD (lambda (n) ( 
                      recurse (get-from-robot android 'move-forward) n )))
(define GOLEFT (get-from-robot android 'move-left))
(define DROP_OBJECT (get-from-robot android 'drop-object))
(define PICK_OBJECT (get-from-robot android 'pick-object))
(define TURN_LEFT (get-from-robot android 'turn-left))
(define TURN_RIGHT (get-from-robot android 'turn-right))
(define LOG (get-from-robot android 'log))

(LOG 0)


; Rewrite log to show one line. Use sleep.
;

(define commands (list 
  (TURN_RIGHT 1) ; 0,8,1
  (MOVE_FORWARD 8) ; 8,8,1
  (TURN_LEFT 1) ; 8,8,0
  (MOVE_FORWARD 1)
;  (MOVE_FORWARD 3) ; 8, -7, 0, should be 8,4,0
;  (TURN_RIGHT 2)
;  (MOVE_FORWARD 4)
  

;  (MOVE_BACKWARD 4)
;  (PICK_OBJECT "P1")
;  (TURN_RIGHT 3)
;  (MOVE_FORWARD 7)
;  (TURN_RIGHT 1)
;  (DROP_OBJECT "P1")
;  (LOG "test log")
))

commands

