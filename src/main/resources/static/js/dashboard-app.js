const app = angular.module('dashboard-app',[])
app.controller('dashboard-ctrl',function($scope, $http){

    $scope.items=[];
    $scope.form={};
    $scope.cates=[];

    $scope.initialize = function(){
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
    $scope.reset = function(){
        $scope.form = {
            create_date: new Date(),
            image: '',
            available: true
        }
    }

    // Hiển thị lên form
    $scope.edit = function(item){
		$scope.form = angular.copy(item);
    }

    // Thêm sản phẩm mới
    $scope.create =function(){
       var item = angular.copy($scope.form);
       $http.post(`/rest/products`, item).then(resp =>{
        resp.data.create_date = new Date(resp.data.create_date)
        $scope.items.push(resp.data);
        $scope.reset();
       }).catch(error  => {
        console.log("Error", error);
       })
    }

    // Cập nhật sản phẩm
    $scope.update = function(){
        var item = angular.copy($scope.form);
       $http.put(`/rest/products/${item.id}`, item).then(resp =>{
       var index = $scope.items.findIndex(p => p.id == item.id);
       $scope.items[index] = item;
       
       }).catch(error  =>{
      
        console.log("Error", error);
       })
    }

    // Xóa sản phẩm
    $scope.delete = function(item){
        $http.delete(`/rest/products/${item.id}`).then(resp =>{
        var index = $scope.items.findIndex(p => p.id == item.id);
        $scope.items.splice(index, 1);
        $scope.reset();
        
        }).catch(error  =>{
        
         console.log("Error", error);
        })
    }
    
    // Upload hình
    $scope.imageChanged = function(files){
        var data = new FormData();
        data.append('file', files[0]);
        $http.post('/rest/upload/product', data, {
            transformResquest: angular.identity,
            headers: {'Content-Type': undefined}
        }).then(resp => {
            $scope.form.image = resp.data.name;
        }).catch(error => {
            
            console.log("Error", error);
        })
    }
    
})