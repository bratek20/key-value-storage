create TABLE key_value_storage.key_value_pair
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    key_str VARCHAR(255) NOT NULL,
    value_str VARCHAR(255) NOT NULL
);