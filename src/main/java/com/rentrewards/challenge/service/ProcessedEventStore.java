package com.rentrewards.challenge.service;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Tracks which webhook events have already been processed, so that the
 * RewardsEngine can ignore duplicate deliveries from the payment processor.
 */
public class ProcessedEventStore {

    private Set<String> processedEventIds = ConcurrentHashMap.newKeySet();

    public boolean markIfNew(String eventId) {
        return processedEventIds.add(eventId);
    }
}
