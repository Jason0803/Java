/*
 *  For the function which makes the thread (Jumbotron) a chat room
 *  This will be changed to live chatting service (synchronized).
 *  Soo Young Choi. 2017/09/19
 */

$(function() {
    $('button').click(function() {
    	var str;
    	switch(this.id) {
			case 'sendMsg_1': {
    			str = $('#inputMsg_1').val();
    			if(str == "") break;
    			
        		$('#myClass').append('<div class="media">' +
        				  '<div class="media-left">'
        				  + '<img src="./image/img_avatar1.png" class="media-object" style="width:60px">'
        				  + '</div>'
        				  + '<div class="media-body"><h4 class="media-heading">(174) 최수영</h4>'
        				  + '<p>' + str + ' (17.09.22)</p></div></div>');
        		break;
    		}
    		case 'sendMsg_2' : {
    			str = $('#inputMsg_2').val();
    			if(str == "") break;
    			$('#allClass').append('<p>(174) 최수영 : ' + str +' (17.09.18)</p>');
    			break;
    		}
    	}
    });
});