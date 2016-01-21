(function() {

    var writeln = function(line) {
        $("#output").append(line).append("<br>");
    };

    var var1 = "Global Scope Variable";

    function globalFunction1() {
        var var1 = "Function Scope Variable";
        writeln(var1);
        if (true) {
            var var1 = "This is still the same function scope variable. JS has no block scope.";
        }
        writeln(var1);
    }

    function hoistingDemo() {
        writeln("The var1 is acctrually a local variable rather than golbal variable because of Hoisting, now it value is undefined: " + var1);
        var var1 = "Value of Local var1";
        writeln("Now the value of local var1 is: " + var1);
    }

    $(document).ready(function() {
        globalFunction1();
        writeln(var1);
        hoistingDemo();
    });

})();
