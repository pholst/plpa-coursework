
(define floor
	( vector 
		(vector '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '0 '0 '0 '-)
		(vector '- '- '- '- 'g 'g 'v 'g 'g 'g 'g 'g 'g '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '0 '0 '0 '-)
		(vector '- '- '- '- '- '1 '1 '1 'g '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- 'v '- '-)
		(vector '- '- '- '- '- '1 '1 '1 'g '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- 'g '- '-)
		(vector '- '- '- '- '- '1 '1 '1 '> '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- 'g '- '-)
		(vector '- '- '- '- '- '- '- '- 'g '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- 'g '- '-)
		(vector '- '- '- '- '- '- '- '- 'g '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- 'g '- '-)
		(vector 'b 'b 'b '- '- '- '- '- 'g '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- 'g '- '-)
		(vector 'r 'g 'g 'g 'g 'g 'g 'g 'g 'g 'g 'g 'g 'g 'g 'g 'g 'g 'g 'g 'g 'g 'g 'g 'g 'g 'g 'g 'g 'g '- '-)
		(vector 'r 'g 'g 'g '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- 'g '- '- '- '- '- 'g '- '- 'g '- '-)
		(vector 'r 'g 'g 'g '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- 'g '- '- '- '- '- 'g '- '- 'g '- '-)
		(vector 'r 'g 'g 'g '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '> '2 '2 '2 '2 '2 '> '- '- 'g '- '-)
		(vector 'r 'g 'g 'g '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- 'g '- '- '- '- '- 'g '- '- 'g '- '-)
		(vector 'r 'g 'g 'g 'g 'g 'g 'g 'g 'g 'g 'g 'g 'g 'g 'g 'g 'g 'g 'g 'g 'g 'g 'g 'g 'g 'g 'g 'g 'g '- '-)
		(vector 'r 'g 'g 'g '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- 'g '- '- '- '- '- '- '- 'g '- '-)
		(vector 'b 'b 'b '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '3 '3 '3 '< '- '- '- '- '- '- '- 'g '- '-)
		(vector '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '3 '3 '3 'g '- '- '- '- '- '- '- 'g '- '-)
		(vector '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '3 '3 '3 'g '- '- '- '- '- '- '- 'g '- '-)
		(vector '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '3 '3 '3 'g '- '- '- '- '- '- '- 'g '- '-)
		(vector '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '3 '3 '3 '> '- '- '- '- '- '- '- 'g '- '-)
		(vector '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- 'g '- '- '- '- '- '- '- 'g '- '-)
		(vector '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- 'v '- '-)
		(vector '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '4 '4 '4 '-)
		(vector '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '- '4 '4 '4 '-)
))

(define getTile
  (lambda (x y grid)
    (vector-ref (vector-ref grid y) x)))

(define isLegalTile
  (lambda (x y grid)
    (cond 
      [(equal? (getTile x y grid) '-) #f]
      [(equal? (getTile x y grid) 'b) #f]
      [(equal? (getTile x y grid) '0) #f]
	  [(equal? (getTile x y grid) '1) #f]
	  [(equal? (getTile x y grid) '2) #f]
	  [(equal? (getTile x y grid) '3) #f]
	  [(equal? (getTile x y grid) '4) #f]
      [else #t]
    )))

     



(define sleeptime 0.8)

(define pcount 0)
(define logFileLocation "/Users/ragnar/school/15-2-TIPLPA/project/pholst-gui/plpa-coursework/log.txt")

(define (create-robot name)
  (let* (
        (position (cons 0 8)) ;; Start in upper corner in red area
        (direction 0) ; 0->E, 1->S, 2->W, 3->N
        (hasObject #f)
        
        (log (lambda (t)
              (with-output-to-file logFileLocation (lambda () (
              
                                                                                                                              
                  ; Log file structure:
                  ; PC, X, Y, DIRECTION
                  ; Should the program counter be updated at every step? 
                                                                                                                             
                  printf (string-append 
                          (number->string pcount) ","
                          (number->string (car position)) ","
                          (number->string (cdr position)) ","
                          (number->string direction)
                          "\n"))) #:exists 'truncate)
               ))

          (error-log (lambda (t)
               (with-output-to-file logFileLocation (lambda () (
                         ; Log file structure:
                         ; PC, X, Y, DIRECTION
                         printf (string-append 
                            "error,"
                            (number->string pcount)
                            "....."
                            "\n"))) #:exists 'truncate))
               )
        (lastDirection (cons 0 0))

        
        (turn-left (lambda (n) 
                      (begin
                        (sleep sleeptime)
                        (set! pcount (+ 1 pcount))
                        (set! direction (modulo (- direction n) 4)))))
        
        (turn-right (lambda (n) 
                     (begin 
                       (sleep sleeptime)
                       (set! pcount (+ 1 pcount))
                       (set! direction (modulo (+ n direction) 4)))))
        
        (move-up (lambda ()
                   (set! position (cons (car position) (- (cdr position) 1)))
                 position))
        
        (move-right (lambda () 
         (set! position (cons (+ (car position) 1) (cdr position)))
          position))
        
              
        (move-down (lambda () 
         (set! position (cons (car position) (+ 1 (cdr position))))
          position)) 

            
        (move-left (lambda () 
          (set! position (cons (- (car position) 1) (cdr position)))
          position))

        (newpos (lambda (pos, direction)
                      (if (= direction 0)
                         (cons
                           (car pos) ; if direction = 1,3, modify
                           (- (cdr pos) 1)
                      )
                                                 
                                (if (= direction 1) 
                                    (cons (+ (car pos) 1) (cdr pos)) 
                                    (if (= direction 2) 
                                        (cons (car pos) (+ (cdr pos) 1))  
                                        (cons (- (car pos) 1) (cdr pos))
                                ))) 
                
                    ))
        
        (move-forward (lambda (number_of_steps)
                        (begin
                            
                            (display "Moving from ")
                            (display position)
                            (display " to ")
                            (display (newpos position direction))
                            
                            (if (isLegalTile (car (newpos position direction)) (cdr (newpos position direction)) floor) 
                                (begin 
                                  (display " (√) ") 
                                     (if (= direction 0)
                                       (move-up) 
                                       (if (= direction 1) 
                                         (move-right) 
                                         (if (= direction 2) 
                                           (move-down)  
                                           (move-left)
                                ))))
                                (begin 
                                  (display " (X) ")
                                  (error-log pcount)
                                  (exit)
                            )) 
                            
                            (display position)
                            (display newpos)
                            (display " dir: ")(display direction)
                            (sleep sleeptime)
                            (log number_of_steps)
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
                          (begin
                            (error-log pcount)
                            (exit)
                          ))))
                   
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
  (begin
    (cdr (assq name (cdr r)))))

(define android (create-robot "android"))


(define (recurse fn n)
  (if (= n 0)
      null
      (begin
        (fn n)

        (recurse fn (- n 1)))))



; Mappings from our dsl -> robot
(define MOVE_FORWARD (lambda (n)  
                      (begin 
                        (set! pcount (+ 1 pcount))
                        (recurse (get-from-robot android 'move-forward) n )
                      )))
(define DROP_OBJECT (get-from-robot android 'drop-object))
(define PICK_OBJECT (get-from-robot android 'pick-object))
(define TURN_LEFT (get-from-robot android 'turn-left))
(define TURN_RIGHT (get-from-robot android 'turn-right))
(define LOG (get-from-robot android 'log))



; List of commands (fed from GUI)

(LOG 0) ; Places the robot in (0 . 8)

(TURN_RIGHT 1)
(MOVE_FORWARD 8)
(TURN_LEFT 1)
(MOVE_FORWARD 7)
(TURN_LEFT 1)
(MOVE_FORWARD 2)
(TURN_LEFT 1)
(PICK_OBJECT "P1")
(TURN_LEFT 1)
(MOVE_FORWARD 2)
(TURN_RIGHT 1)
(MOVE_FORWARD 3)
(TURN_RIGHT 1)
(DROP_OBJECT "P1")
(TURN_LEFT 1)
(MOVE_FORWARD 4)
(TURN_LEFT 1)
(MOVE_FORWARD 12)
(TURN_RIGHT 1)
(MOVE_FORWARD 5)






