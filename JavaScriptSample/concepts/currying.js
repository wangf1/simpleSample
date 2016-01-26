// 1. https://javascriptweblog.wordpress.com/2010/04/05/curry-cooking-up-tastier-functions/
// 2. <JavaScript: The Good Parts> 4.14. Curry
// 3. http://stackoverflow.com/questions/5176313/javascript-curry
// 4. http://stackoverflow.com/questions/113780/javascript-curry-what-are-the-practical-applications
// I am still not convinced to actually use curry...
(function() {

    var writeln = function(line) {
        $("#output").append(line).append("<br>");
    };

    var add = function addF(arg1, arg2) {
        var sum = arg1 + arg2;
        return sum;
    };

    var simpleCurryDemo = function simpleCurryDemoF() {

        var add1 = function add1F(arg2) {
            var result = add.call(null, 1, arg2);
            return result;
        };

        var add1To7 = add1(7);

        writeln(add1To7);
    };

    var converter = function(ratio, symbol, input) {
        return [
            (input * ratio).toFixed(1), symbol
        ].join(" ");
    };

    var curry = function curryF(func) {
        var curryArgs = Array.prototype.slice.call(arguments, 1);
        var curried = function curriedF() {
            var allArgs = curryArgs.concat(Array.prototype.slice.apply(arguments));
            var result = func.apply(null, allArgs);
            return result;
        };
        return curried;
    };

    var genericCurryDemo = function genericCurryDemoF() {
        var add1 = curry(add, 1);

        var add1To7 = add1(7);

        writeln(add1To7);

        var kilosToPounds = curry(converter, 2.2, "lbs");
        var milesToKilometers = curry(converter, 1.62, "km");

        var twoKilosEqualsNPounds = kilosToPounds(2);
        writeln("2 kilos = " + twoKilosEqualsNPounds);

        var twoMilesEqualsNKilometers = milesToKilometers(2);
        writeln("2 miles = " + twoMilesEqualsNKilometers);
    };

    $(document).ready(function() {
        simpleCurryDemo();
        genericCurryDemo();
    });

})();
