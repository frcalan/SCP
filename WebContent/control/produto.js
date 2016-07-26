var produtoModule = angular.module('produtoModule', []);

produtoModule.controller("produtoControl", function($scope, $http){

	urlFornecedor = 'http://localhost:8080/SCP/rs/fornecedor';
	urlProduto = 'http://localhost:8080/SCP/rs/produto';
	
	$scope.pesquisarFornecedor = function() {
		$http.get(urlFornecedor).success(function (fornecedores) {
			$scope.fornecedores = fornecedores;
		}).error(function (erro) {
			alert(erro);
		});
	}
	
	$scope.pesquisarProduto = function(){
		$http.get(urlProduto).success(function (produtos){
			$scope.produtos = produtos;
		}).error(function (erro){
			alert(erro);
		});
	}
	
	$scope.salvar = function(){
		if($scope.produto.codigo == ''){
			$http.post(urlProduto,$scope.produto).success(function(produto) {
				$scope.produtos.push($scope.produto);
				$scope.novo();		
			}).error(function (erro){
				alert(erro);
			});			
		} else {
			$http.put(urlProduto,$scope.produto).success(function(produto) {
				$scope.pesquisarProduto();
				$scope.novo();		
			}).error(function (erro){
				alert(erro);
			});	
		}
		
	}
	
	$scope.excluir = function() {
		if ($scope.produto.codigo == '') {
			alert('Selecione um produto');
		} else {
			urlExcluir = urlProduto+'/'+$scope.produto.codigo;
			$http.delete(urlExcluir).success(function () {
				$scope.pesquisarProduto();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}
	}
	
	$scope.selecionaProduto = function(produto){
		$scope.produto = produto;
	}
	
	$scope.novo = function(){
		$scope.produto = "";
	}
	
	$scope.pesquisarFornecedor();
	$scope.pesquisarProduto();
});