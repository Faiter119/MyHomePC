/**
 * Created by OlavH on 17-Oct-16.
 */

$(document).ready(function () {

    $("#addNewNodeButton").click(function () {

        console.log("click");

        $(document.body).append("<div class='node'></div>");

        connectAllNodes();
        $(".node").draggable();

    });

    $(".node").draggable();

/*

    var dragging = false;
    $(".node").onmousedown(function () {

        dragging = true;

        connectAllNodes();
    });

    $(".node").onmouseup(function () {
        dragging = false;
    });
*/

    });

function connectAllNodes() {

    var nodes = $(".node");

    for (var i = 0; i<nodes.length-1; i++){
        var node1 = nodes[i];
        var node2 = nodes[i+1];
        console.log(node1);

        connect(node1, node2, "#9B0300", 2);

    }

}
function connect(div1, div2, color, thickness) { // draw a line connecting elements

    var off1 = getOffset(div1);
    var off2 = getOffset(div2);
    // bottom right
    var x1 = off1.left + off1.width;
    var y1 = off1.top + off1.height;
    // top right
    var x2 = off2.left + off2.width;
    var y2 = off2.top;
    // distance
    var length = Math.sqrt(((x2-x1) * (x2-x1)) + ((y2-y1) * (y2-y1)));
    // center
    var cx = ((x1 + x2) / 2) - (length / 2);
    var cy = ((y1 + y2) / 2) - (thickness / 2);
    // angle
    var angle = Math.atan2((y1-y2),(x1-x2))*(180/Math.PI);
    // make hr
    var htmlLine = "<div style='padding:0px; margin:0px; height:" + thickness + "px; background-color:" + color + "; line-height:1px; position:absolute; left:" + cx + "px; top:" + cy + "px; width:" + length + "px; -moz-transform:rotate(" + angle + "deg); -webkit-transform:rotate(" + angle + "deg); -o-transform:rotate(" + angle + "deg); -ms-transform:rotate(" + angle + "deg); transform:rotate(" + angle + "deg);' />";
    //
    // alert(htmlLine);
    document.body.innerHTML += htmlLine;

}
    function getOffset(el) {

        return { top: $(el).offset().top, left:$(el).offset().left, width: $(el).width(), height: $(el).height() }

    };

