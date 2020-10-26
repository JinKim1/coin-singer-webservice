var index = {
    init : function (){
        var _this = this;
        $('#btn-save').on('click',function(){_this.save();});
        $('#btn-update').on('click',function(){_this.update();});
        $('#btn-delete').on('click',function(){_this.delete();});
        $('#btn-save-comment').on('click',function(){_this.saveComment();});
        $('#btn-save-sr').on('click',function(){_this.savesr();});
        $('#btn-update-sr').on('click',function(){_this.updatesr();});
        $('#btn-delete-sr').on('click',function(){_this.deletesr();});
    },

    save : function(){
        var data = {
            writer: $('#writer').val(),
            title: $('#title').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/board',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(){alert('등록되었습니다.');
        window.location.href='/board';
        }).fail(function(error){alert(JSON.stringify(error));
        });
    },

    saveComment : function(){
        var data = {
            board_id : $('#id').val(),
            writer: $('#writer').val(),
            content: $('#comment').val()
        };

        var id = $('#id').val();
        $.ajax({
            type: 'POST',
            url: '/api/v1/comment',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(){alert('등록되었습니다.');
        window.location.href='/boardRead/'+id;
        }).fail(function(error){alert(JSON.stringify(error));
        });
    },

    savesr : function(){
            var data = {
                name: $('#name').val(),
                location: $('#location').val(),
                img1: $('#img1').val(),
                img2: $('#img2').val(),
                price: $('#price').val(),
                star: $('#star').val(),
                facility: $('#facility').val()
            };

            $.ajax({
                type: 'POST',
                url: '/api/v1/srboard',
                dataType: 'json',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(data)
            }).done(function(){alert('등록되었습니다.');
            window.location.href='/srboard';
            }).fail(function(error){alert(JSON.stringify(error));
            });
        },

    delete : function (){
        var id = $('#id').val();

        $.ajax({
            type:'DELETE',
            url: '/api/v1/board/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
        }).done(function(){
            if (confirm('삭제하시겠습니까?')) {
                  alert('글이 삭제되었습니다.');
                  window.location.href='/board';
            } else {
                  window.location.href='/boardRead/'+id;
            }
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },

    deletesr : function (){
        var id = $('#id').val();

        $.ajax({
            type:'DELETE',
            url: '/api/v1/srboard/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
        }).done(function(){
            if (confirm('삭제하시겠습니까?')) {
                  alert('글이 삭제되었습니다.');
                  window.location.href='/srboard';
            } else {
                  window.location.href='/srboardRead/'+id;
            }
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },

    update : function(){
        var data = {
            writer: $('#writer').val(),
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/board/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(){
            if (confirm('저장하시겠습니까?')) {
                  alert('글이 수정되었습니다.');
                  window.location.href='/board';
            } else {
                  window.location.href='/boardRead/'+id;
            }
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },

    updatesr : function(){
        var data = {
            name: $('#name').val(),
            location: $('#location').val(),
            img1: $('#img1').val(),
            img2: $('#img2').val(),
            price: $('#price').val(),
            star: $('#star').val(),
            facility: $('#facility').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/srboard/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(){
            if (confirm('저장하시겠습니까?')) {
                  alert('글이 수정되었습니다.');
                  window.location.href='/srboard';
            } else {
                  window.location.href='/srboardRead/'+id;
            }
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    }

};

index.init();