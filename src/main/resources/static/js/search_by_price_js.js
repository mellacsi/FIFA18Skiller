$.getScript('https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js', function() {
    var allPlayers;
    $(document).ready(function () {
        $("form").submit(function (event) {
            searchPlayers($("input:first").val());
            event.preventDefault();
        });

        function searchPlayers(price) {
            $.ajax({
                url: "/players/price/" + price,
                dataType: 'json'
            })
                .done(function (data) {
                    allPlayers = [];
                    for (var i = 0; i < data.length; i++) {
                        allPlayers.push(data[i]);
                    }
                    drawTable();
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