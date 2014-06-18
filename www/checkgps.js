    var exec = require('cordova/exec');

    var gpsDetect = function() {};

    gpsDetect.prototype.checkGPS = function(successCallback, failureCallback) {
        exec(successCallback, failureCallback, 'CheckGps', 'gpsDetection', []);
    };

    gpsDetect.prototype.checkNP = function(successCallback, failureCallback) {
        exec(successCallback, failureCallback, 'CheckGps', 'npDetection', []);
    };
    
    var gpsDetect = new gpsDetect();
    module.exports = gpsDetect;
