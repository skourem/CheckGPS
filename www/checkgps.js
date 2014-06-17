//ordova.define('cordova/plugin/checkgps', function(require, exports, module) {
    var exec = require('cordova/exec');

    var gpsDetect = function() {};

    gpsDetect.prototype.checkGPS = function(successCallback, failureCallback) {
        exec(successCallback, failureCallback, 'CheckGps', 'gpsDetection', []);
    };
    
    var gpsDetect = new gpsDetect();
    module.exports = gpsDetect;
//});