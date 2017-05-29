Notify = function (text, callback, close_callback) {

    // 10 secounds
    var time = '10000';
    var $container = $('#notifications');
    var icon = '<i class="fa fa-info-circle "></i>';


    var html = $('<div style="opacity: 0.5;overflow: hidden "  class="demo-card alert  mdl-card mdl-color--amber-600 mdl-shadow--2dp mdl-button--colored hover-changer hide"  ><div class="mdl-card__title"   > <h6 style="font-size:medium ; margin-bottom: 3px" class="mdl-card__title-text"><i style="padding-top: 4px; padding-right: 4px;font-size: medium" class="material-icons">announcement</i>Notification</h6></div><div class="mdl-card__supporting-text " style="font-size: medium ; color: white" > ' + text + '</div></div>');


    var audio = new Audio('soft-bells.mp3');
    audio.play();
    $container.prepend(html)
    html.removeClass('hide').hide().fadeIn('slow')

    function remove_notice() {
        html.stop().fadeOut('slow').remove()
    }

    var timer = setInterval(remove_notice, time);

    $(html).hover(function () {
        clearInterval(timer);
    }, function () {
        timer = setInterval(remove_notice, time);
    });

    html.on('click', function () {
        clearInterval(timer)
        callback && callback()
        remove_notice()
    });


}
