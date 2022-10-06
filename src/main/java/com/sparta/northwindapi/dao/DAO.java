package com.sparta.northwindapi.dao;

import com.sparta.northwindapi.dto.DTO;

import java.util.List;
import java.util.Optional;

/**
 * Data Access Object (DAO).<br>
 * Used for abstracting database CRUD (create, read, update, delete) operations.
 * @param <T> The DTO type
 */
public interface DAO<T extends DTO> {
    // CRUD: create, read, update, delete

    /**
     * Inserts a new item to the database.
     * @param item the item to be inserted
     * @return the {@code id} of the inserted item, if added successfully<br>
     * {@code -1}, if not
     */
    int insert(T item);

    /**
     * Inserts a new item into the database with a specified {@code id}.
     * @param item the item to be inserted
     * @param id the {@code id} of the item
     * @return {@code true} if inserted<br>
     * {@code false} if not
     */
    boolean insertById(T item, int id);

    /**
     * Fetch an item from the database with a specified {@code id}.
     * @param id the {@code id} of the item
     * @return the result
     */
    Optional<T> findById(int id);

    /**
     * Fetch all items from the database.
     * @return a {@code List} of found items
     */
    List<T> findAll();

    /**
     * Updates an item in a database.
     * @param item the updated item
     * @return the {@code id} of the updated item, if updated successfully<br>
     * {@code -1}, if not
     */
    int update(T item);

    /**
     * Updates an item in a database with a specified {@code id}.
     * @param item the updated item
     * @param id the {@code id} of the item
     * @return {@code true} if updated<br>
     * {@code false} if not
     */
    boolean updateById(T item, int id);

    /**
     * Deletes an item in the database.
     * @param item the item to be deleted
     * @return the {@code id} of the deleted item, if deleted successfully<br>
     * {@code -1}, if not
     */
    int delete(T item);

    /**
     * Deletes an item in the database at a specified {@code id}.
     * @param id the {@code id} of the item
     * @return {@code true} if deleted<br>
     * {@code false} if not
     */
    boolean insertById(int id);

    /**
     * Deletes all items in the database.
     * @return {@code true} if deleted<br>
     * {@code false} if not
     */
    boolean deleteAll();
}
