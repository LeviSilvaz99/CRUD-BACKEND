package br.com.treinaweb.producer;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.ext.ContextResolver;
import jakarta.ws.rs.ext.Provider;



@Provider
    @Produces(MediaType.APPLICATION_JSON)


    public class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {

        @Inject
        private ObjectMapper mapper;

        @Override
        public ObjectMapper getContext(Class<?> type) {
            return mapper;
        }
    }

