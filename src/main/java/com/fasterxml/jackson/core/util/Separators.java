package com.fasterxml.jackson.core.util;

import java.io.Serializable;

/**
 * Value class used with some {@link com.fasterxml.jackson.core.PrettyPrinter}
 * implements
 *
 * @see com.fasterxml.jackson.core.util.DefaultPrettyPrinter
 * @see com.fasterxml.jackson.core.util.MinimalPrettyPrinter
 */
public class Separators implements Serializable
{
    private static final long serialVersionUID = 1;

    private final char _objectNameValueSeparator;
    private final char _objectEntrySeparator;
    private final char _arrayElementSeparator;

    public static Separators createDefaultInstance() {
        return new Separators();
    }

    public Separators() {
        this(':', ',', ',');
    }

    public Separators(char objectFieldValueSeparator,
            char objectEntrySeparator, char arrayValueSeparator) {
        _objectNameValueSeparator = objectFieldValueSeparator;
        _objectEntrySeparator = objectEntrySeparator;
        _arrayElementSeparator = arrayValueSeparator;
    }
    
    public Separators withObjectFieldValueSeparator(char sep) {
        return (_objectNameValueSeparator == sep) ? this
                : new Separators(sep, _objectEntrySeparator, _arrayElementSeparator);
    }

    public Separators withObjectEntrySeparator(char sep) {
        return (_objectEntrySeparator == sep) ? this
                : new Separators(_objectNameValueSeparator, sep, _arrayElementSeparator);
    }

    public Separators withArrayValueSeparator(char sep) {
        return (_arrayElementSeparator == sep) ? this
                : new Separators(_objectNameValueSeparator, _objectEntrySeparator, sep);
    }

    public char getObjectNameValueSeparator() {
        return _objectNameValueSeparator;
    }

    public char getObjectEntrySeparator() {
        return _objectEntrySeparator;
    }

    public char getArrayValueSeparator() {
        return _arrayElementSeparator;
    }
}
