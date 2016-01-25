(function() {

    var writeln = function(line) {
        $("#output").append(line).append("<br>");
    };

    function createExampleClosure(arg1, arg2) {
        var localVar = 8;
        function toReturn(innerArg) {
            var result = (arg1 + arg2) / (localVar + innerArg);
            return result;
        }
        return toReturn;
    }

    function useTheExampleClosure() {
        var closure1 = createExampleClosure(2, 4);
        var result = closure1(4);// (2+4)/(8+4)
        var result2 = closure1(16);// (2+4)/(8+16)
        writeln("(2+4)/(8+4) = " + result);
        writeln("(2+4)/(8+16) = " + result2);

        var closure2 = createExampleClosure(3, 5);
        var result3 = closure2(16);
        writeln("(3+5)/(8+16)" + result3);
    }

    function setObjectPropertyByClosure(object, propertyKey, propertyValue) {
        // function closureCanCallLater does not take any parameter,
        // the parameters passed by parent function, as closure execution context
        // so the closure can be call by setTimeout
        function closureCanCallLater() {
            object[propertyKey] = propertyValue;
        }
        return closureCanCallLater;
    }

    function callTheClosureLater() {
        var object = {
            "key": "value1"
        };

        writeln("Original object property: " + object.key);

        var toCallLater1 = setObjectPropertyByClosure(object, "key", "valueUpdated1");

        setTimeout(toCallLater1, 100);
        setTimeout(function() {
            writeln("Object property updated after 100 milliseconds: " + object.key);
        }, 200);

        var toCallLater2 = setObjectPropertyByClosure(object, "key", "valueUpdated2");

        var deferredObject = $.Deferred();
        setTimeout(function() {
            toCallLater2();
            deferredObject.resolve();
        }, 1000);
        deferredObject.done(function() {
            writeln("Object property updated after 1 seconds: " + object.key);
        });
    }

    function useClosureEncapsulatePrivateVariables() {
        function createCounter(start) {
            var count = start;
            // Both increment and get are closures
            return {
                increment: function() {
                    count++;
                },

                get: function() {
                    return count;
                }
            };
        }
        var foo = createCounter(4);
        foo.increment();
        var next = foo.get();
        writeln("Next of 4 is: " + next);
    }

    function closrueInLoop() {
        for (var i = 0; i < 10; i++) {
            setTimeout(function() {
                // Write 10 times of 10 rather than 1..10
                writeln(i);
            }, 200);
        }

        for (i = 0; i < 10; i++) {
            // Anonymous immediate function keep a local copy of i, so it can print 1..10.
            // Extract the anonymous immediate function a named function can make the code easy to understand.
            (function(j) {
                setTimeout(function() {
                    writeln(j);
                }, 300);
            })(i);
        }

        for (i = 10; i < 20; i++) {
            // Use the setTimeout which can take parameters
            setTimeout(function(e) {
                writeln(e);
            }, 1000, i);
        }
    }

    $(document).ready(function() {
        useTheExampleClosure();
        callTheClosureLater();
        useClosureEncapsulatePrivateVariables();
        closrueInLoop();
    });

})();
