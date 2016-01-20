var writeln = function(line) {
    $("#output").append(line).append("<br>");
};

(function(global) {
    "use strict";

    var Module = (function() {

        var data = "secret";

        var _privateMethod = function() {
            writeln("This is private method.");
        };

        var publicMethod = function() {
            writeln("This is public method, which call private method.");
            _privateMethod();
        };

        var toExpose = {
            // This is some boolean property
            bool: true,
            // Some string value
            string: "a string",
            // An array property
            array: [
                1, 2, 3, 4
            ],
            // An object property
            object: {
                lang: "en-Us"
            },
            getData: function() {
                // get the current value of `data`
                return data;
            },
            setData: function(value) {
                // set the value of `data` and return it
                data = value;
                return data;
            },
            publicMethod: publicMethod
        };
        return toExpose;
    })();

    // Other things might happen here

    // expose our module to the global object
    global.Module = Module;

})(this);// The parameter this is the window object.

function declareModule(moduleName) {
    var arrayOfStrings = moduleName.split(".");
    var root = window[arrayOfStrings[0]];
    root = root || {};
    var parent = root;
    for (var i = 1; i < arrayOfStrings.length; i++) {
        var child = parent[arrayOfStrings[i]];
        child = child || {};
        parent[arrayOfStrings[i]] = child;
        parent = child;
    }
    window[arrayOfStrings[0]] = root;
}
// Note window.com.example.myGlobalNameSpace and com.example.myGlobalNameSpace are same thing.
// See http://stackoverflow.com/a/5117172/1029242
declareModule("com.example.myGlobalNameSpace");

(function(global) {
    "use strict";

    var theSubModule = (function() {

        var _privateMethod = function() {
            writeln("This is private method in module com.example.myGlobalNameSpace.subModule.");
        };

        var publicMethod = function() {
            writeln("This is public method in module com.example.myGlobalNameSpace.subModule, which call private method.");
            _privateMethod();
        };

        var toExpose = {
            publicMethod: publicMethod
        };
        return toExpose;
    })();

    // Other things might happen here

    // expose our module to the global object
    global.subModule = theSubModule;

})(com.example.myGlobalNameSpace);

$(document).ready(function() {
    window.Module.publicMethod();
    com.example.myGlobalNameSpace.subModule.publicMethod();
});
