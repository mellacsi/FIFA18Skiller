$.when(
    $.getScript( "/node_modules/chart.js/dist/Chart.js" ),
    $.getScript( "https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ),
    $.getScript( "js/MyRequestsCompleted.js"),
    $.Deferred(function( deferred ){
        $( deferred.resolve );
    })
).done(function(){

    var allSkils;
    var radarSkills = [];
    $(document).ready(function() {
        var requestCallback = new MyRequestsCompleted({
            numRequest: 1,
            singleCallback: function () {
                draw();
            }
        });

        var url = window.location.href + "";
        var id = url.split('=')[1];
        searchPlayer(id);

        function searchPlayer(id) {
            $.ajax({
                url: "/player/id/" + id,
                dataType: 'json'
            })
                .done(function (data) {
                    allSkils = Object.keys(data).map(function(key) {
                        return [String(key), data[key]];
                    });
                    requestCallback.requestComplete(true);
                });
        }

        function draw() {
            console.log("Fatto");
            radarSkills[0] = (allSkils[33] + "").split(',')[1];
            radarSkills[1] = (allSkils[31] + "").split(',')[1];
            radarSkills[2] = (allSkils[30] + "").split(',')[1];
            radarSkills[3] = (allSkils[18] + "").split(',')[1];
            radarSkills[4] = (allSkils[15] + "").split(',')[1];
            radarSkills[5] = (allSkils[36] + "").split(',')[1];

            new Chart(document.getElementById("radar-chart"), {
                type: 'radar',
                data: {
                    labels: ["Velocità", "Tiri", "Passaggi", "Dribling", "Difesa", "Fisico"],
                    datasets: [
                        {
                            label: "Abilità",
                            fill: true,
                            backgroundColor: "rgba(179,181,198,0.2)",
                            borderColor: "rgba(179,181,198,1)",
                            pointBorderColor: "#fff",
                            pointBackgroundColor: "rgba(179,181,198,1)",
                            data: radarSkills
                        }
                    ]
                },
                options: {
                    scale: {
                        ticks: {
                            // changes here
                            beginAtZero: true,
                            max: 100,
                            min: 0
                        }
                    }
                    ,
                    title: {
                        display: true,
                        text: 'Radar abilità'
                    }
                }
            });
            var table = "" +
                "<table class='table table-hover'>" +
                "<thead>" +
                "<tr>\n" +
                "<th scope='col'>Attributo</th>\n" +
                "<th scope='col'>Valore</th>\n" +
                "</tr>" +
                "</thead>" +
                "<tbody>";

            for(var i = 0; i < allSkils.length; i++){
                table += "<tr>";
                //console.log(allPlayers[i]);
                var skill = (allSkils[i] + "").split(',');
                table += "<td scope='row'>" + skill[0]; + "</td>";
                table += "<td>" + skill[1] + "</td>";
                table += "</tr>" ;
            }
            table +="</tbody></table>";
            $(".tableSpace").append(table);
        };
    });
});
