angular.module("atp").controller("coachController", function($http, $scope) {
	// do something
});

angular.module("atp").controller("rankingController", function($http, $scope) {
	// do something
});

angular.module("atp").controller("tournamentManageController", function($http, $scope) {
	$http({
		method: "GET", url: "/home/tournament/all"
	}).then(function(response) {
		$scope.allTournaments = response.data;
	});
	$scope.deleteTournament = function(){
		$http({
			method: "DELETE", url: "/home/tournament/delete/" + $scope.tournamentId
		}).then(function(response) {
			if(response.statusText === "No Content"){
				window.alert("Tournament Deleted");
			}else{
				window.alert("Not valid tournament id");
			}
		}, function(reason) {
			window.alert("Not valid tournament id");
		});
	}
});

angular.module("atp").controller("tournamentCreateController", function($http, $scope) {
	$scope.createTournament = function(){
		$http.post("/home/tournament/create", $scope.tournament)
		.then(function(value) {
			window.alert("Tournament Added");
		})
	}
});

angular.module("atp").controller("tournamentJoinController", function($http, $scope) {
	$scope.joinTournament = function(){
		var urlString = "/home/tournament/join/" + $scope.tournamentId + "/" + $scope.playerId;
		$http({
			method: "PUT", url: urlString
		}).then(function(response) {
			if(response.statusText === "OK"){
				window.alert("Joined Tournament");
			}else{
				window.alert(response.statusText);
			}
		}, function(reason) {
			window.alert(reason.statusText);
		});
	}
});

angular.module("atp").controller("logoutController", function($http, $scope) {
	// do something
});

angular.module("atp").controller("createRequestController", function($http, $scope) {
	$scope.createRequest = function() {
		$http.post("/home/request/create", $scope.request)
		.then(function(value) {
			window.alert("Request added");
		})
	}
});

angular.module("atp").controller("getAllRequestController", function($http, $scope) {
	$http({
		method: "GET", url: "/home/request/all"
	}).then(function(response) {
		$scope.allRequests = response.data;
	})
});


//angular.module("atp").controller("createRequestController")



//angular.module("atp").controller("createRequestController")