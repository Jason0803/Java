$(function() {
	var secondP = $('p:eq(1)');
	$('a.more').click(function name() {
		if(secondP.is(':hidden')) {
			secondP.slideToggle('slow');
			$(this).html('read less');
		} else {
			secondP.slideToggle('slow');
			$(this).html('read more');
		}
	});
	
	var defaultSize = speech.css('font-size');
	var num = parseInt(defaultSize, 10);
	
	$('#swither>button').click(function() {
		switch(this.id) {
			case 'switcher-large': {
				num += 5;
				break;
			}
			case 'switcher-small': {
				num -= 5;
				break;
			}
			default: num = parseInt(defaultSize,10);
		}
	});
});