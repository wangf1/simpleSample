(function jQueryDeferredDemo() {
    "use strict";
    var writeln = function(line) {
        $("#output").append(line).append("<br>");
    };

    function doAsync() {
        writeln("Async operation call begin.");
        var deferredObject = new $.Deferred();
        setTimeout(function() {
            var radomValue = Math.random();
            if (radomValue >= 0.1) {
                deferredObject.resolve(radomValue, " can have ", " any args");
            } else {
                deferredObject.reject(radomValue, " maybeSomeErrorCode ");
            }
        }, 1000);
        writeln("Async operation call return.");
        return deferredObject.promise();
    }

    var promise = doAsync();
    promise.done(function(value, value2, value3) {
        writeln("The async operation success, so the deferred object return: [" + value + value2 + value3 + "]");
    });
    promise.done(function(value, value2, value3) {
        writeln("The 2nd callback of the promise done event: [" + value + value2 + value3 + "]");
    });
    promise.fail(function(value, value2) {
        writeln("The async operation failed: [" + value + value2 + "]");
    });
    promise.always(function(value, value2, value3) {
        writeln("The async operation finished: [" + value + value2 + value3 + "]");
    });

    $(document).ready(doAsync);

    var displayValue1And2 = function(v1, v2) {
        writeln("value1: " + v1);
        writeln("value2: " + v2);
    };
    // combine promises using when
    $.when(doAsync(), doAsync()).done(displayValue1And2).fail(displayValue1And2).always(displayValue1And2);

    /**
     * Old fashion of jQuery Ajax call
     */
    // Should disable Chrome web security to test: "C:\Program Files (x86)\Google\Chrome\Application\chrome.exe" --disable-web-security
    function jQueryAjaxDemoWithoutDeferred() {
        $.ajax({
            "url": "http://services.odata.org/V4/OData/OData.svc/Products(0)",
            "type": "GET",
            "success": function(data) {
                writeln("The product name: : " + data.Name);
            },
            "error": function(error) {
                writeln(error.statusText);
            }
        });
    }

    jQueryAjaxDemoWithoutDeferred();

    /**
     * Chain several jQuery Ajax call to make them execute one by one in sequence.
     */
    // Should disable Chrome web security to test: "C:\Program Files (x86)\Google\Chrome\Application\chrome.exe" --disable-web-security
    function jQueryAjaxPromiseChained() {
        var firstCall = $.get({
            "url": "http://services.odata.org/V4/OData/OData.svc/Products(0)"
        });
        firstCall.fail(function(error) {
            writeln(error.statusText);
        });

        var secondCall = firstCall.then(function(data) {
            writeln("The product name: (Fisrst Call): " + data.Name);
            // second Ajax call happen after first call done, and may use the result data of first call
            var newId = data.ID + 1;
            var get = $.get({
                "url": "http://services.odata.org/V4/OData/OData.svc/Products(" + newId + ")"
            });
            return get;
        });

        var thirdCall = secondCall.then(function(data) {
            writeln("The product name: (Second Call): " + data.Name);
            // 3rd Ajax call happen after 2nd call done, and may use the result data of previous call
            var newId = data.ID + 1;
            var get = $.get({
                "url": "http://services.odata.org/V4/OData/OData.svc/Products(" + newId + ")"
            });
            return get;
        });
        thirdCall.done(function(product) {
            writeln("The product name: (3rd Call): " + product.Name);
        });

    }

    jQueryAjaxPromiseChained();

})();
