function llamar_opcion1() {

    if (window.XMLHttpRequest) {
        // code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    } else {
        // code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            //alert("llegue");
            var div = document.getElementById("opcion1");
            var div2 = document.getElementById("opcion2");
            var div3 = document.getElementById("opcion3");
            if (div.style.display == 'none') {
                div.style.display = '';
                div2.style.display = 'none';
                div3.style.display = 'none';
            }
        }
    };
    xmlhttp.open("GET", "/Pedidos/JSPs/administrar_productos.jsp", true);
    xmlhttp.send();

    return false;
}

function llamar_opcion2() {

    if (window.XMLHttpRequest) {
        // code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    } else {
        // code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            //alert("llegue");
            var div = document.getElementById("opcion1");
            var div2 = document.getElementById("opcion2");
            var div3 = document.getElementById("opcion3");
            if (div2.style.display == 'none') {
                div2.style.display = '';
                div.style.display = 'none';
                div3.style.display = 'none';
            }
        }
    };
    xmlhttp.open("GET", "/Pedidos/JSPs/administrar_productos.jsp", true);
    xmlhttp.send();

    return false;
}

function llamar_opcion3() {

    if (window.XMLHttpRequest) {
        // code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    } else {
        // code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            //alert("llegue");
            var div = document.getElementById("opcion1");
            var div2 = document.getElementById("opcion2");
            var div3 = document.getElementById("opcion3");
            if (div3.style.display == 'none') {
                div3.style.display = '';
                div.style.display = 'none';
                div2.style.display = 'none';
            }
        }
    };
    xmlhttp.open("GET", "/Pedidos/JSPs/administrar_productos.jsp", true);
    xmlhttp.send();

    return false;
}