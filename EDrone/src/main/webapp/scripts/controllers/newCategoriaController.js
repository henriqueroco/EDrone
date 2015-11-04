
angular.module('eDrone').controller('NewCategoriaController', function ($scope, $location, locationParser, flash, CategoriaResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.categoria = $scope.categoria || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The categoria was created successfully.'});
            $location.path('/Categoria');
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        CategoriaResource.save($scope.categoria, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Categoria");
    };
});