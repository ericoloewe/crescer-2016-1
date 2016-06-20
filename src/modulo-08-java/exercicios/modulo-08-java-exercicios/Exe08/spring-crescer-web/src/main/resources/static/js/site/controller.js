
springApp.controller('pessoasController', ['$scope', '$http', function ($scope, $http) {
    $scope.pessoas = [];

    $http({
        method: 'GET',
        url: '/rest/pessoa/listar'
    }).then(function (response) {
        $scope.pessoas = response.data;
    }, function (response) {
        console.error(response);
    });
    
    $scope.deletar = function(pessoa) {
        console.log(pessoa);
    };
}]);