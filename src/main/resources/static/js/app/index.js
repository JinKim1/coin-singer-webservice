var main = {
    init : function (){
        var _this = this;
        $('#btn-save').on('click',function(){_this.save();});
    },

    save : function(){
        var data = {
            footprint: $('#footprint').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/board',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(){alert('등록되었습니다.');
        window.location.href='/';
        }).fail(function(error){alert(JSON.stringify(error));
        });
    }
};

main.init();