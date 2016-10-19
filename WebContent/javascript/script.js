
(function($) {
	$(document).ready(function() {
		$('.animated-form-control').each(function() {
          var group = this;
          $(this).find('.form-control').each(function(){
            $(this).focus(function(){
              $(group).addClass('focus');
            });
            $(this).focusout(function(){
              $(group).removeClass('focus');
            });
          });
        });

        $(".dropdown-menu > li > a.trigger").on("click",function(e){
            if($('#navbar').hasClass('in')) {
                $(this).next().toggle();
		        e.preventDefault();
                e.stopPropagation();
            }
		});

            


	});

}(jQuery));

var gmapStyles = [
    {
        "featureType": "administrative",
        "elementType": "labels.text.fill",
        "stylers": [
            {
                "color": "#444444"
            }
        ]
    },
    {
        "featureType": "landscape",
        "elementType": "all",
        "stylers": [
            {
                "color": "#f2f2f2"
            }
        ]
    },
    {
        "featureType": "poi",
        "elementType": "all",
        "stylers": [
            {
                "visibility": "off"
            }
        ]
    },
    {
        "featureType": "road",
        "elementType": "all",
        "stylers": [
            {
                "saturation": -100
            },
            {
                "lightness": 45
            }
        ]
    },
    {
        "featureType": "road.highway",
        "elementType": "all",
        "stylers": [
            {
                "visibility": "simplified"
            }
        ]
    },
    {
        "featureType": "road.arterial",
        "elementType": "labels.icon",
        "stylers": [
            {
                "visibility": "off"
            }
        ]
    },
    {
        "featureType": "transit",
        "elementType": "all",
        "stylers": [
            {
                "visibility": "off"
            }
        ]
    },
    {
        "featureType": "water",
        "elementType": "all",
        "stylers": [
            {
                "color": "#b9d8ec"
            },
            {
                "visibility": "on"
            }
        ]
    }
]