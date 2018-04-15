$.when(
    $.getScript( "https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ),
    $.getScript( "js/MyRequestsCompleted.js"),
    $.Deferred(function( deferred ){
        $( deferred.resolve );
    })
).done(function() {

    var allPlayers;
    $(document).ready(function () {
        var requestCallback = new MyRequestsCompleted({
            numRequest: 1,
            singleCallback: function () {
                drawTable();
            }
        });

        var url = window.location.href + "";
        var received = url.split('=');
        var pars = [];
        pars.push(received[0].split("?")[1]);
        pars.push(received[1]);
        //console.log(pars[0] + " "+pars[1]);
        searchPlayer(pars);


        function searchPlayer(received) {
            $.ajax({
                url: "/players/" + received[0] + "/" + received[1],
                dataType: 'json'
            })
                .done(function (data) {
                    allPlayers = [];
                    for (var i = 0; i < data.length; i++) {
                        allPlayers.push(data[i]);
                    }
                    requestCallback.requestComplete(true);
                });
        }

        function drawTable() {
            console.log("fatto");
            $(".tableSpace").empty();
            var table = "" +
                "<table class='table table-hover'>" +
                "<thead>" +
                "<tr>\n" +
                "<th scope='col'>Nome</th>\n" +
                "<th scope='col'>Età</th>\n" +
                "<th scope='col'>Totale</th>\n" +
                "<th scope='col'>Prezzo</th>\n" +
                "</tr>" +
                "</thead>" +
                "<tbody>";

            for (var i = 0; i < allPlayers.length; i++) {
                table += "<tr>";
                allPlayers[i] = Object.keys(allPlayers[i]).map(function (key) {
                    return [String(key), allPlayers[i][key]];
                });

                //console.log(allPlayers[i]);
                var id = (allPlayers[i][0] + "").split(',')[1] + "";
                table += "<td scope='row'><a href='find_player.html?id=" + id + "'>" + (allPlayers[i][1] + "").split(',')[1]
                "</a></td>";
                table += "<td>" + (allPlayers[i][2] + "").split(',')[1]
                "</td>";
                table += "<td>" + (allPlayers[i][4] + "").split(',')[1]
                "</td>";
                table += "<td>" + (allPlayers[i][7] + "").split(',')[1]
                "</td>";
                table += "</tr>";
            }
            table += "</tbody></table>";
            $(".tableSpace").append(table);
        };
    });
});