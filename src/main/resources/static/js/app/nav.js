$(document).ready(function(){
        $('.hamburger-button').click(function(ev){
            ev.preventDefault();
            $(this).toggleClass('active');
            $('.overlay').toggleClass('visible');
    });
});