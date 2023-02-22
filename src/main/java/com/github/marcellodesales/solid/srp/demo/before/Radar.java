package com.github.marcellodesales.solid.srp.demo.before;

import java.util.List;

public class Radar {
    private int originLat;
    private int originLon;

    public Radar(int originLat, int originLon) {
        this.originLat = originLat;
        this.originLon = originLon;
    }

    public String getAircraftInRange(int range, List<AircraftTarget> allAircraft, boolean latFirst) {
        // First responsibility is to calculate the range
        var aircraftInRange = allAircraft
                .stream()
                .filter(a -> {
                    var distance = (int) Math.sqrt(
                            (originLat - a.lat()) * (originLat - a.lat()) +
                                    (originLon - a.lon()) * (originLon - a.lon()));
                    return distance <= range;
                })
                .toList();

        // Second responsibility is to format the output...
        // That's too much already for this method!
        var sb = new StringBuilder();
        if (latFirst) {
            aircraftInRange.forEach(a -> sb
                    .append("[")
                    .append(a.lat())
                    .append(" ")
                    .append(a.lon())
                    .append("] "));
        } else {
            aircraftInRange.forEach(a -> sb
                    .append("[")
                    .append(a.lon())
                    .append(" ")
                    .append(a.lat())
                    .append("] "));
        }

        return sb.toString();
    }
}
