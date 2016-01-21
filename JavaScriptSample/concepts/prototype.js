//Reference: https://javascriptweblog.wordpress.com/2010/06/07/understanding-javascript-prototypes/
(function() {

    var writeln = function(line) {
        $("#output").append(line).append("<br>");
    };

    function viewPrototypeOfAObject() {
        var a = {};
        var p1 = Object.getPrototypeOf(a); // [object Object] IE9+ and others
        var p2 = a.__proto__; // [object Object] IE not support this way
        // all browsers
        // (but only if constructor.prototype has not been replaced and fails with Object.create)
        var p3 = a.constructor.prototype; // [object Object]
        writeln("Prototype of a object literal is: " + p1);
        writeln("Three approave to get prototype can return same object. " + ((p1 === p2) && (p2 === p3)));
    }

    function prototypeWithoutConstructor() {
        var a = {
            "p1": "v1"
        };
        var b = {};
        b.__proto__ = a;
        writeln("We can set object prototype this way, but we should not go this way, since it is not a cross browser approach, we should use constructor insread." + b.p1);
    }

    function prototypeWithConstructor() {
        // A function’s prototype property is the object that will be assigned as the prototype to all instances created when this function is used as
        // a constructor.
        // It’s important to understand that a function’s prototype property has nothing to do with it’s actual prototype.
        var Circle = function(radius) {
            this.radius = radius;
            // next line is implicit, added for illustration only
            // this.__proto__ = Circle.prototype;
        };
        var a = new Circle(3);
        var b = new Circle(4);

        Circle.prototype.area = function() {
            var area = Math.PI * this.radius * this.radius;
            return area;
        };

        writeln("The area of circle a: " + a.area());
        writeln("The area of circle b: " + b.area());

        writeln("Default prototype is an object with one property, the constructor. " + (a.constructor === Circle));
    }

    function prototypeChain() {
        function A() {
            this.keyA = "a";
        }
        ;
        function B() {
            this.keyB = "b";
        }
        B.prototype = new A();

        var b = new B();
        writeln("b has both A and B properties. " + b.keyA + ", " + b.keyB);

        writeln("Constructor of b: " + b.constructor);
        B.prototype.constructor = B;
        writeln("Constructor of b: " + b.constructor);
    }

    $(document).ready(function() {
        viewPrototypeOfAObject();
        prototypeWithoutConstructor();
        prototypeWithConstructor();
        prototypeChain();
    });

})();
