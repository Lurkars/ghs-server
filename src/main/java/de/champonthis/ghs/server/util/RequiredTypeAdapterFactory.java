/**
 * 
 */
package de.champonthis.ghs.server.util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * A factory for creating RequiredTypeAdapter objects.
 */
public class RequiredTypeAdapterFactory implements TypeAdapterFactory {

	/*
	 * @see com.google.gson.TypeAdapterFactory#create(com.google.gson.Gson,
	 * com.google.gson.reflect.TypeToken)
	 */
	@Override
	public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {

		final TypeAdapter<T> delegate = gson.getDelegateAdapter(this, type);

		return new TypeAdapter<T>() {
			@Override
			public void write(JsonWriter out, T value) throws IOException {
				if (value != null) {

					Field[] fields = value.getClass().getDeclaredFields();

					for (int i = 0; i < fields.length; i++) {
						if (fields[i].isAnnotationPresent(Required.class)) {
							validateNullValue(value, fields[i]);
						}

					}
				}
				delegate.write(out, value);
			}

			private <E> void validateNullValue(T value, Field field) {
				field.setAccessible(true);
				Class<?> t = field.getType();
				Object v = null;
				try {
					v = field.get(value);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					throw new IllegalArgumentException(e);
				}
				if (v == null) {
					throw new IllegalArgumentException(field.getName() + " is null");
				}

				if (List.class.isAssignableFrom(t) && !((ArrayList<?>) v).isEmpty()) {
					for (Object item : ((ArrayList<?>) v)) {
						if (item == null) {
							throw new IllegalArgumentException(field.getName() + " has null item");
						}
					}
				}
			}

			@Override
			public T read(JsonReader in) throws IOException {
				return delegate.read(in);
			}

		};
	}

}
