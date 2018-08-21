(function() {

	angular.module('app.services', []);
	angular.module('app.controllers', []);
	angular.module('app.modules', [ 'app.services', 'app.controllers' ]);
	angular.module('app', [ 'app.modules' ]);

})();
