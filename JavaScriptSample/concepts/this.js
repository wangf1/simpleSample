(function() {

    var writeln = function(line) {
        $("#output").append(line).append("<br>");
    };
    /**
     * Global scope this never has any practical use.<br>
     * "this" in function call refer to the global object.<br>
     * "this" in method call refer to the object itself.
     */
    function globalScopeThis() {
        var result = this === window;
        writeln("this in a function call (rather than a method call) refer to the global object. 'this' is the window object? " + result);

        var obj = {
            "property1": "value1",
            func: function() {
                writeln("this in a method call refer the object. 'this' is the window object? " + (this === window));
                function innerFunc() {
                    writeln("innerFunc() is also a normal function call, so this refer the global object. 'this' is the window object? " + (this === window));
                }
                innerFunc();
            }
        };

        obj.func();
    }

    $(document).ready(function() {
        globalScopeThis();
    });

})();
