var fornecedorModule = angular.module('fornecedorModule',[])

	fornecedorModule.controller("fornecedorControl", function($scope, $http){
	
		urlFornecedor = 'http://localhost:8080/SCP/rs/fornecedor';
		
		$scope.pesquisarFornecedor = function () {
			$http.get(urlFornecedor).success(function (fornecedores){
				$scope.fornecedores = fornecedores;
			}).error(function (erro){
				alert(erro);
			});
		}
		
		$scope.salvar = function(){
			if($scope.fornecedor.codigo == ''){
				$http.post(urlFornecedor,$scope.fornecedor).success(function(fornecedor) {
					$scope.fornecedores.push($scope.fornecedor);
					$scope.novo();		
				}).error(function (erro){
					alert(erro);
				});			
			} else {
				$http.put(urlFornecedor,$scope.fornecedor).success(function(fornecedor) {
					$scope.pesquisarFornecedor();
					$scope.novo();		
				}).error(function (erro){
					alert(erro);
				});	
			}
			
		}
		
		$scope.excluir = function() {
			if ($scope.fornecedor.codigo == '') {
				alert('Selecione um Fornecedor');
			} else {
				urlExcluir = urlFornecedor+'/'+$scope.fornecedor.codigo;
				$http.delete(urlExcluir).success(function () {
					$scope.pesquisarFornecedor();
					$scope.novo();
				}).error(function (erro) {
					alert(erro);
				});
			}
		}
		
		$scope.selecionaFornecedor = function(fornecedor){
			$scope.fornecedor = fornecedor;
		}
		
		$scope.novo = function(){
			$scope.fornecedor = "";
		}
		
		$scope.pesquisarFornecedor();
})
