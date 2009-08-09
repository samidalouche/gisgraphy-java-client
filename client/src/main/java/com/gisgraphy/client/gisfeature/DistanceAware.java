package com.gisgraphy.client.gisfeature;

import javax.measure.quantity.Length;
import javax.measure.unit.Unit;

public interface DistanceAware<T> {
    double distance(T o, Unit<Length> unit);
}
