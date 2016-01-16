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
        writeln(msg);
    });

    Q.delay(1000).thenResolve("thenResolve is a short cut of the then(function(){return something})").then(function(msg) {
        writeln(msg);
    });

    var chainPromises = function() {
        var getUser = function(id) {
            return Q.delay(500).thenResolve({
                "id": id,
                "name": "User" + id
            });
        };
        var getTweetsByUser = function(user) {
            return Q.delay(600).thenResolve([
                {
                    "user": user.name,
                    "message": "Tweet 1"
                }, {
                    "user": user.name,
                    "message": "Tweet 2"
                }
            ]);
        };
        getUser(123).then(getTweetsByUser).then(function(tweets) {
            tweets.forEach(function(t) {
                writeln(t.user + " says: " + t.message);
            });
        });
    };

    chainPromises();

    // Should disable Chrome web security to test: "C:\Program Files (x86)\Google\Chrome\Application\chrome.exe" --disable-web-security
    var qWithAjaxDemo = function() {

        function wrapJQueryAjaxWithQ(ajaxSettings) {
            var defer = Q.defer();
            $.ajax(ajaxSettings).done(defer.resolve).fail(defer.reject);
            return defer.promise;
        }
        var getFirstProduct = wrapJQueryAjaxWithQ({
            "url": "http://services.odata.org/V4/OData/OData.svc/Products(0)",
            "type": "GET"
        });

        function getNextProduct(previousProduct) {
            writeln("Previous product: " + previousProduct.ID + " " + previousProduct.Name);
            var id = previousProduct.ID + 1;
            var call = wrapJQueryAjaxWithQ({
                "url": "http://services.odata.org/V4/OData/OData.svc/Products(" + id + ")",
                "type": "GET"
            });
            return call;
        }

        getFirstProduct.then(getNextProduct).then(getNextProduct).then(function(thirdProduct) {
            writeln("Properties of the 3rd product:");
            for ( var p in thirdProduct) {
                writeln(thirdProduct[p]);
            }
        });
    };

    qWithAjaxDemo();

})();
