(function jQueryDeferredDemo() {
    "use strict";

    var writeln = function(line) {
        $("#output").append(line).append("<br>");
    };

    Q.delay(2000).then(function() {
        writeln("Success after delay 2 seconds.");
    }, function() {
        writeln("Some thing wrong.");
    });

    Q.delay(1000).then(function() {
        var message = "the result of first promise, will passed to the second promise.";
        return message;
    }).then(function(msg) {
        writeln(msg)
    });
})();
