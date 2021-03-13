$(document).ready(function () {
    $('.table .eBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');

        $.get(href, function (user, status) {
            $('.myForm #id').val(user.id);
            $('.myForm #username').val(user.username);
            $('.myForm #lastName').val(user.lastName);
            $('.myForm #email').val(user.email);
        })

        $('.myForm #exampleModal').modal();
    });
});

$(document).ready(function () {
    $('.table .eBtnDelete').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');

        $.get(href, function (user, status) {
            $('.myFormDelete #id').val(user.id);
            $('.myFormDelete #username').val(user.username);
            $('.myFormDelete #lastName').val(user.lastName);
            $('.myFormDelete #email').val(user.email);
            $('.myFormDelete #roles').val(user.roles);
        })

        $('.myFormDelete #exampleModalDelete').modal();
    });
});