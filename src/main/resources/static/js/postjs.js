function post() {
    var postID = $("#post_id").val();
    var content = $("#reply_content").val();
    ajaxx(postID, content);
}

function ajaxx(postId, content) {
    if (!content) {
        alert("empty reply");
        return;
    }

    $.ajax({
        type: "POST",
        url: "/reply",
        contentType: 'application/json',
        data: JSON.stringify({
            "postId": postId,
            "content": content
        }),
        success: function (){
            window.location.reload(true);
        },
        error: function(){
            window.location.reload(true);
        },
        dataType: "json"
    });
}