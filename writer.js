var fs = require('fs');

var instr = [
	'0,1,10,1',
	'1,2,10,1',
	'1,3,10,1',
	'2,3,10,2',
	'3,3,11,2',
	'3,3,12,2',
	'3,3,13,2',
	'4,3,13,1',
	'5,4,13,1',
	'5,5,13,1',
	'5,6,13,1',
	'5,7,13,1',
	'5,8,13,1',
	'5,9,13,1',
	'5,10,13,1',
	'5,11,13,1',
	'5,12,13,1',
	'5,13,13,1',
	'5,14,13,1',
	'5,15,13,1',
	'5,16,13,1',
	'5,17,13,1',
	'5,18,13,1',
	'5,19,13,1',
	'5,20,13,1',
	'6,20,13,0',
	'7,20,12,0',
	'7,20,11,0',
	'7,20,10,0',
	'7,20,9,0',
	'7,20,8,0',
	'8,20,8,1',
	'9,21,8,1',
	'9,22,8,1',
	'9,23,8,1',
	'9,24,8,1',
	'9,25,8,1',
	'9,26,8,1',
	'10,26,8,2',
	'11,26,9,2',
	'11,26,10,2',
	'11,26,11,2',
	'11,26,12,2',
	'11,26,13,2',
	'error "The robot got tired... poor guy.."' 
];

(function start(instr) {
	var timeout = 1000;
	var i = 0;

	function repeat() {
		fs.writeFile('log.txt', instr[i], function (err) { });
		console.log('Wrote: ' + instr[i]);
		i++;
		if (i < instr.length) {
			setTimeout(repeat, timeout);
		}
	}
	repeat();
}(instr));

