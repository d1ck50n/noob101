var bootstrapApp = angular.module('bootstrapApp', []);

bootstrapApp.constant('jellyBean', 4.2);

bootstrapApp.controller('BootCtrl', function ($scope, $http, jellyBean) {
  $scope.phones = [
    {'name': 'Nexus S',
     'snippet': 'Fast just got faster with Nexus S.'},
    {'name': 'Motorola XOOM™ with Wi-Fi',
     'snippet': 'The Next, Next Generation tablet.'},
    {'name': 'MOTOROLA XOOM™',
     'snippet': 'The Next, Next Generation tablet.'}
  ];
  
  $http.get('js/phones.json').success(function(data){
     $scope.phonez = data;
  });
  
   $scope.version = jellyBean;
  
});