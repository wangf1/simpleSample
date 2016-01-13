(function() {
	var writeln = function(line) {
		$("#output").append(line).append("<br>");
	};

	function doAsync() {
		writeln("Async operation call begin.");
		var deferredObject = $.Deferred();
		setTimeout(function() {
			deferredObject.resolve();
		}, 1000);
		writeln("Async operation call return.");
		return deferredObject.promise();
	}

	var promise = doAsync();
	promise.done(function() {
		writeln("The async operation done, so the deferred object return.");
	});

	$(document).ready(doAsync);

})();
