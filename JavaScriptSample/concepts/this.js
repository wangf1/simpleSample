(function() {

    var writeln = function(line) {
        $("#output").append(line).append("<br>");
    };
    /**
     * Global scope this never has any practical use.<br>
     * "this" in function call refer to the global object.<br>
     * "this" in method call refer to the object itself.
     */
    function thisInFunctionCallAndMethodCall() {
        var result = this === window;
        writeln("this in a function call (rather than a method call) refer to the global object. 'this' is the window object? " + result);

        var obj = {
            "property1": "value1",
            func: function() {
                writeln("this in a method call refer the object. 'this' is the window object? " + (this === window));
                var that = this;
                function innerFunc() {
                    writeln("innerFunc() is also a normal function call, so this refer the global object. 'this' is the window object? " + (this === window));
                    that.property1 = "the_new_value";
                    writeln("inner function can use 'that' refer 'correct this i.e. the object', so we can set the 'property1' to a new value: " + that.property1);
                }
                innerFunc();
            }
        };

        obj.func();
    }
    /**
     * "this" in constructor refer the newly created object.
     */
    function thisInConstructor() {
        function Person(name, age) {
            this.name = name;
            this.age = age;
        }

        var john = new Person("John", 20);
        writeln(john.name + " - " + john.age);
    }

    function thisInApplyAndCallMethod() {
        function toApply(theOjbectToApplyAgainst) {
            writeln("Apply this function to a object, the 'this' is the object to apply against: " + (this === theOjbectToApplyAgainst));
            for (p in this) {
                writeln("Property of 'this': " + p + ":" + this[p]);
            }
        }
        var obj = {
            "property1": "value1",
            "property2": "value2"
        };
        toApply.apply(obj, obj);
        toApply.call(obj, obj);
    }

    $(document).ready(function() {
        thisInFunctionCallAndMethodCall();
        thisInConstructor();
        thisInApplyAndCallMethod();
    });

})();
