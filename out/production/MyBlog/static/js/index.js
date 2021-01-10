$(document).ready(function () {

    $('#loginChange').click(function () {
        $('#loginChange').removeClass('btn-info');
        $('#loginChange').addClass('btn-info');
        $('#registerChange').removeClass('btn-info');

        // $('#loginChange').css('background-color' , '#FFDEAB');
        // $('#loginChange').css('border-color' , '#FFDEAB');
        // $('#loginChange').css('color' , '#90000a');
        //
        // $('#registerChange').remove('background-color');
        // $('#registerChange').remove('border-color');
        // $('#registerChange').remove('color' );

        $('#loginDiv').show();
        $('#registerDiv').hide();
    });
    $('#registerChange').click(function () {
        $('#registerChange').addClass('btn-info');
        $('#loginChange').removeClass('btn-info');

        // $('#registerChange').css('background-color' , '#FFDEAB');
        // $('#registerChange').css('border-color' , '#FFDEAB');
        // $('#registerChange').css('color' , '#90000a');
        //
        // $('#loginChange').remove('background-color');
        // $('#loginChange').remove('border-color');
        // $('#loginChange').remove('color' );

        $('#registerDiv').show();
        $('#loginDiv').hide();
    });
})