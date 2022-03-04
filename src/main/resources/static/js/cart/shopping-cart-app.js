const app = angular.module("shopping-cart-app",[]);

app.controller("shopping-cart-ctrl", function($scope, $http) {

	$scope.cart = {
		items : [],
		//Thêm sản phẩm vào giỏ hàng
		add(id){
			var item = this.items.find(item => item.id == id);
			if(item){
				item.qty++;
				this.saveToLocalStorage();
			}else{
				$http.get(`/rest/products/${id}`).then(resp => {
					resp.data.qty = 1;
					this.items.push(resp.data);
					this.saveToLocalStorage();
				})
			}
			
		},		
		//Lưu giỏ hàng vào local storage
		saveToLocalStorage(){
			var json = JSON.stringify(angular.copy(this.items));
			localStorage.setItem("cart", json);
		},
	}
})

