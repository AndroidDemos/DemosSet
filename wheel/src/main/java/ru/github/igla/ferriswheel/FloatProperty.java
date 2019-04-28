package ru.github.igla.ferriswheel;

import android.util.Property;

/*
 * @author Zeus
 * create at 2019/4/13 9:49
 * modify at 2019/4/13 9:49
 * modify because
 * description: TO FIT
 */
public abstract class FloatProperty<T> extends Property<T, Float> {

    private FloatProperty(String name) {
        super(Float.class, name);
    }

    @Override
    public Float get(T object) {
        return 0f;
    }

    /**
     * A type-specific variant of {@link #set(Object, Float)} that is faster when dealing
     * with fields of type <code>float</code>.
     */
    public abstract void setValue(T object, float value);

    @Override
    final public void set(T object, Float value) {
        setValue(object, value);
    }

    public static FloatProperty createAngleProperty(final OnAngleChangeListener listener) {
        return new FloatProperty<OnAngleChangeListener>("angle") {
            @Override
            public void setValue(OnAngleChangeListener obj, float value) {
                listener.onValueChange(value);
            }
        };
    }
}
