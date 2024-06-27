package com.fatecbs.PassagensOnline.dto;

import java.time.Duration;

public class DurationDto {
    private Duration hours;

    public DurationDto(long hours) {
        this.hours = Duration.ofHours(hours);
    }

    public Duration getDuration() {
        return hours;
    }

    public void setHours(long hours) {
        this.hours = Duration.ofHours(hours);
    }
}
