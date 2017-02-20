/**
 * Created by cc on 2017/2/14.
 */
angular.module('demo', [])
    .controller('book', function($scope, $http) {
        $http.get('http://localhost:8080/book2').
        then(function(response) {
            $scope.book = response.data;
        });
    });