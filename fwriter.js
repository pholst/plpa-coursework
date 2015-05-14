var fs = require('fs');
var readline = require('readline');

var rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});


var recursiveAsyncReadLine = function () {
	rl.question("Enter [PC,X,Y,DIR]: ", function(answer) {
		fs.writeFile('log.txt', answer + "\n", function(err) { });
		recursiveAsyncReadLine();
	});
};

recursiveAsyncReadLine();
