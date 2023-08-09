const app = angular.module('dashboard-app', [])
app.controller('dashboard-ctrl', function ($scope, $http, $location, $window) {

    // $routeProvider
    // 	.when('/list', {
    // 		templateUrl: '/admin/list/product.html',
    // 		controller: 'dashboard-ctrl',
    // 	})
    // 	.when('/add/:id', {
    // 		templateUrl: '/admin/manage/product.html',
    // 		controller: 'dashboard-ctrl',
    // 	})

    $scope.items = [];
    $scope.form = {};
    $scope.cates = [];
    $scope.status

    $scope.order = {
        items: [],
        loadOrder() {
            $http.get("/rest/orders").then(resp => {
                this.items = resp.data
            })
        },
        delete(item) {
            $http.delete(`/rest/orders/${item.id}`).then(resp => {
                var index = $scope.items.findIndex(p => p.id == item.id);
                this.items.splice(index, 1);
                $scope.order.loadOrder();
            }).catch(err => {
                alert("err: " + err)
            })
        },
        orderDetails: [],
        view(item) {
            $http.get(`/rest/orderDetails/${item.id}`).then(resp => {
                this.orderDetails = resp.data;
            })
        },
        changeStatus(item, status) {
            item.status = status
            console.log(status)
            $http.put(`/rest/orders/${item.id}`, item).then(resp => {
                $scope.order.loadOrder();
            })
        }
    };
    $scope.order.loadOrder();
    $scope.initialize = function () {
        // Load sản phẩm
        $http.get("/rest/products").then(resp => {
            $scope.items = resp.data;
            $scope.items.forEach(item => {
                item.createDate = new Date(item.createDate)
            })
        });
        //Load category
        $http.get("/rest/categories").then(resp => {
            $scope.cates = resp.data;
        });
    }

    $scope.initialize();

    // Xóa form
    $scope.reset = function () {
        $scope.form = {
            create_date: new Date(),
            image: '',
            available: true
        }
    }

    // Hiển thị lên form
    $scope.edit = function (item) {
        var url = `http://localhost:8080/admin/product/add`;
        $window.location.href = url;
        $http.get(`/rest/products/${item.id}`).then(resp =>{
            $scope.form = resp.data
            console.log($scope.form)
            console.log(resp.data)
        })
    }
    $scope.size
    $scope.color
    // Thêm sản phẩm mới
    $scope.create = function () {
        var item = angular.copy($scope.form);

        console.log($scope.size)
        $http.post(`/rest/products`, item).then(resp => {
            resp.data.create_date = new Date(resp.data.create_date)
            $scope.items.push(resp.data);
            $http.post('/rest/size',$scope.size).then(resp => {
                
            })
            $scope.reset();
        }).catch(error => {
            console.log("Error", error);
        })
    }

    // Cập nhật sản phẩm
    $scope.update = function () {
        var item = angular.copy($scope.form);
        $http.put(`/rest/products/${item.id}`, item).then(resp => {
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items[index] = item;

        }).catch(error => {

            console.log("Error", error);
        })
    }

    // Xóa sản phẩm
    $scope.delete = function (item) {
        $http.delete(`/rest/products/${item.id}`).then(resp => {
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items.splice(index, 1);
            $scope.reset();

        }).catch(error => {

            console.log("Error", error);
        })
    }

    // Upload hình
    $scope.imageChanged = function (files) {
        var data = new FormData();
        data.append('file', files[0]);
        $http.post('/rest/upload/product', data, {
            transformResquest: angular.identity,
            headers: { 'Content-Type': undefined }
        }).then(resp => {
            $scope.form.image = resp.data.name;
        }).catch(error => {

            console.log("Error", error);
        })
    }
    
    
	// ---------
	// Category function
	
	$scope.categories = [];
	$scope.category = {};
	$scope.editing = false;

	function fetchCategories() {
        $http.get('/rest/categories').then(function(response) {
            $scope.categories = response.data;
        });
    }
    
    fetchCategories();
    
    $scope.addCategory = function() {
        $http.post('/rest/categories', $scope.category).then(function(response) {
            $scope.categories.push(response.data);
            $scope.resetForm();
        });
    };
    
    $scope.resetForm = function() {
        $scope.category = {};
        $scope.editing = false;

    };
    
    $scope.updateCategory = function() {
        $http.put('/rest/categories/' + $scope.category.id, $scope.category).then(function(response) {
            console.log('Danh mục đã được cập nhật:', response.data);
			alert('Danh mục đã được cập nhật:', response.data)
            var updatedCategory = response.data;
            var index = $scope.categories.findIndex(function(c) {
                return c.id === updatedCategory.id;
            });
            if (index !== -1) {
                $scope.categories[index] = updatedCategory;
            }
            // ...
        }, function(error) {
            console.error('Lỗi khi cập nhật danh mục:', error);
        });
    };

    $scope.editCategory = function(category) {
        $scope.editing = true;
        $scope.category = angular.copy(category);
    };

   $scope.deleteCategory = function(category) {
        var confirmDelete = confirm('Bạn có chắc muốn xóa danh mục này?');
        if (confirmDelete) {
            $http.delete('/rest/categories/' + category.id).then(function(response) {
                console.log('Danh mục đã được xóa:', category);
                fetchCategories();
                 $scope.resetForm();
            }, function(error) {
                console.error('Lỗi khi xóa danh mục:', error);
            });
        }
	};
	
})