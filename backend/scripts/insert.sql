INSERT INTO movie (id, title, description, duration, release_date, rating)
VALUES
    ('MV_a1b2c3d4e5f', 'The Matrix', 'A computer hacker learns about the true nature of his reality.', 136, '1999-03-31', 'R'),
    ('MV_g6h7i8j9k0lm', 'Inception', 'A thief who steals corporate secrets...', 148, '2010-07-16', 'PG-13'),
    ('MV_n7o8p9q0r1s2t', 'Interstellar', 'A team of explorers travel through a wormhole in space...', 169, '2014-11-07', 'PG-13'),
    ('MV_u2v3w4x5y6z7a', 'Parasite', 'Greed and class discrimination threaten the relationship...', 132, '2019-05-30', 'R'),
    ('MV_b2c3d4e5f6g7h', 'The Dark Knight', 'Batman raises the stakes in his war on crime.', 152, '2008-07-18', 'PG-13'),
    ('MV_d8e9f0g1h2i3j', 'Forrest Gump', 'The presidencies of Kennedy and Johnson...', 142, '1994-07-06', 'PG-13'),
    ('MV_k3l4m5n6o7p8q', 'Pulp Fiction', 'The lives of two mob hitmen...', 154, '1994-10-14', 'R'),
    ('MV_r9s0t1u2v3w4x', 'The Lion King', 'Lion prince Simba and his father are targeted...', 88, '1994-06-15', 'G'),
    ('MV_y5z6a7b8c9d0e', 'Fight Club', 'An insomniac office worker and a devil-may-care soap maker...', 139, '1999-10-15', 'R'),
    ('MV_f1g2h3i4j5k6l', 'The Shawshank Redemption', 'Two imprisoned men bond over a number of years...', 142, '1994-09-23', 'R');

INSERT INTO theater (id, name, location)
VALUES
    ('THR_n1o2p3q4r5s6t', 'Regal Cinema', 'Downtown');

INSERT INTO screen (id, theater_id, name, number_of_rows, number_of_columns)
VALUES
    ('SC_b3c4d5e6f7g8h', 'THR_n1o2p3q4r5s6t', 'Screen 1', 10, 20);

INSERT INTO screening (id, movie_id, screen_id, timestamp)
VALUES
    ('SCG_1a2b3c4d5e6', 'MV_a1b2c3d4e5f', 'SC_b3c4d5e6f7g8h', '2024-06-15 12:00:00'),
    ('SCG_7h8i9j0k1l2', 'MV_g6h7i8j9k0lm', 'SC_b3c4d5e6f7g8h', '2024-06-15 12:20:00'),
    ('SCG_3m4n5o6p7q8', 'MV_n7o8p9q0r1s2t', 'SC_b3c4d5e6f7g8h', '2024-06-15 12:40:00'),
    ('SCG_9r0s1t2u3v4', 'MV_u2v3w4x5y6z7a', 'SC_b3c4d5e6f7g8h', '2024-06-15 13:00:00'),
    ('SCG_5w6x7y8z0a1', 'MV_b2c3d4e5f6g7h', 'SC_b3c4d5e6f7g8h', '2024-06-15 13:20:00'),
    ('SCG_2b3c4d5e6f7', 'MV_d8e9f0g1h2i3j', 'SC_b3c4d5e6f7g8h', '2024-06-15 13:40:00'),
    ('SCG_8g9h0i1j2k3', 'MV_k3l4m5n6o7p8q', 'SC_b3c4d5e6f7g8h', '2024-06-15 14:00:00'),
    ('SCG_4l5m6n7o8p9', 'MV_r9s0t1u2v3w4x', 'SC_b3c4d5e6f7g8h', '2024-06-15 14:20:00'),
    ('SCG_1q2r3s4t5u7', 'MV_y5z6a7b8c9d0e', 'SC_b3c4d5e6f7g8h', '2024-06-15 14:40:00'),
    ('SCG_7v8w9x0y1z2', 'MV_f1g2h3i4j5k6l', 'SC_b3c4d5e6f7g8h', '2024-06-15 15:00:00'),
    ('SCG_3a4b3c5d7e8', 'MV_a1b2c3d4e5f', 'SC_b3c4d5e6f7g8h', '2024-06-15 15:20:00'),
    ('SCG_9a0i1h2i3j4', 'MV_g6h7i8j9k0lm', 'SC_b3c4d5e6f7g8h', '2024-06-15 15:40:00'),
    ('SCG_5k6l7m8n9o0', 'MV_n7o8p9q0r1s2t', 'SC_b3c4d5e6f7g8h', '2024-06-15 16:00:00'),
    ('SCG_1p2q3r7z5t6', 'MV_u2v3w4x5y6z7a', 'SC_b3c4d5e6f7g8h', '2024-06-15 16:20:00'),
    ('SCG_7u8v9w0x1y2', 'MV_b2c3d4e5f6g7h', 'SC_b3c4d5e6f7g8h', '2024-06-15 16:40:00'),
    ('SCG_3z4a5b6c7d8', 'MV_d8e9f0g1h2i3j', 'SC_b3c4d5e6f7g8h', '2024-06-15 17:00:00'),
    ('SCG_9e0f1g2h3i4', 'MV_k3l4m5n6o7p8q', 'SC_b3c4d5e6f7g8h', '2024-06-15 17:20:00'),
    ('SCG_5j6k7l8m9n0', 'MV_r9s0t1u2v3w4x', 'SC_b3c4d5e6f7g8h', '2024-06-15 17:40:00'),
    ('SCG_1o2p3q4r5s9', 'MV_y5z6a7b8c9d0e', 'SC_b3c4d5e6f7g8h', '2024-06-15 18:00:00'),
    ('SCG_7t8u9v0w1x2', 'MV_f1g2h3i4j5k6l', 'SC_b3c4d5e6f7g8h', '2024-06-15 18:20:00'),
    ('SCG_3y4z5a6b7c8', 'MV_a1b2c3d4e5f', 'SC_b3c4d5e6f7g8h', '2024-06-15 18:40:00'),
    ('SCG_9d0e1f2g3h4', 'MV_g6h7i8j9k0lm', 'SC_b3c4d5e6f7g8h', '2024-06-15 19:00:00'),
    ('SCG_5i6j7k8l9m0', 'MV_n7o8p9q0r1s2t', 'SC_b3c4d5e6f7g8h', '2024-06-15 19:20:00'),
    ('SCG_1n2o3p4q5r6', 'MV_u2v3w4x5y6z7a', 'SC_b3c4d5e6f7g8h', '2024-06-15 19:40:00'),
    ('SCG_7s8t9u0v1w2', 'MV_b2c3d4e5f6g7h', 'SC_b3c4d5e6f7g8h', '2024-06-15 20:00:00');


INSERT INTO screening (id, movie_id, screen_id, timestamp)
VALUES
    ('SCG_9s0t1u2v3w4', 'MV_u2v3w4x5y6z7a', 'SC_b3c4d5e6f7g8h', '2024-06-16 11:00:00'),
    ('SCG_5x6y7z0a1b2', 'MV_b2c3d4e5f6g7h', 'SC_b3c4d5e6f7g8h', '2024-06-16 11:20:00'),
    ('SCG_2c3d4e5f6g7', 'MV_d8e9f0g1h2i3j', 'SC_b3c4d5e6f7g8h', '2024-06-16 11:40:00'),
    ('SCG_8h9i0j1k2l3', 'MV_k3l4m5n6o7p8q', 'SC_b3c4d5e6f7g8h', '2024-06-16 12:00:00'),
    ('SCG_4m5n6o7p8q9', 'MV_r9s0t1u2v3w4x', 'SC_b3c4d5e6f7g8h', '2024-06-16 12:20:00'),
    ('SCG_1r2s3g4u3v6', 'MV_y5z6a7b8c9d0e', 'SC_b3c4d5e6f7g8h', '2024-06-16 12:40:00'),
    ('SCG_7w8x9y0z1b3', 'MV_f1g2h3i4j5k6l', 'SC_b3c4d5e6f7g8h', '2024-06-16 13:00:00'),
    ('SCG_1q2r3s4t5u6', 'MV_u2v3w4x5y6z7a', 'SC_b3c4d5e6f7g8h', '2024-06-16 14:20:00'),
    ('SCG_7v8w9x0y1z3', 'MV_b2c3d4e5f6g7h', 'SC_b3c4d5e6f7g8h', '2024-06-16 14:40:00'),
    ('SCG_3a4b5c6d7e8', 'MV_d8e9f0g1h2i3j', 'SC_b3c4d5e6f7g8h', '2024-06-16 15:00:00'),
    ('SCG_9f0g1h2i3j4', 'MV_k3l4m5n6o7p8q', 'SC_b3c4d5e6f7g8h', '2024-06-16 15:20:00'),
    ('SCG_6h7i8j9k0l1', 'MV_r9s0t1u2v3w4x', 'SC_b3c4d5e6f7g8h', '2024-06-16 15:40:00'),
    ('SCG_2o3p4q5r6s7', 'MV_y5z6a7b8c9d0e', 'SC_b3c4d5e6f7g8h', '2024-06-16 16:00:00'),
    ('SCG_8t9u0v1w2x3', 'MV_f1g2h3i4j5k6l', 'SC_b3c4d5e6f7g8h', '2024-06-16 16:20:00'),
    ('SCG_2n3o4p5q6r7', 'MV_u2v3w4x5y6z7a', 'SC_b3c4d5e6f7g8h', '2024-06-16 17:40:00'),
    ('SCG_8s9t0u1v2w3', 'MV_b2c3d4e5f6g7h', 'SC_b3c4d5e6f7g8h', '2024-06-16 18:00:00');

INSERT INTO screening (id, movie_id, screen_id, timestamp)
VALUES
    ('SCG_8r9t0z1w2q3', 'MV_k3l4m5n6o7p8q', 'SC_b3c4d5e6f7g8h', '2024-06-17 12:00:00'),
    ('SCG_4s5d6f7g8h9', 'MV_r9s0t1u2v3w4x', 'SC_b3c4d5e6f7g8h', '2024-06-17 12:20:00'),
    ('SCG_1j2k2l1m5n6', 'MV_y5z6a7b8c9d0e', 'SC_b3c4d5e6f7g8h', '2024-06-17 12:40:00'),
    ('SCG_7x8c9v0b1n2', 'MV_f1g2h3i4j5k6l', 'SC_b3c4d5e6f7g8h', '2024-06-17 13:00:00'),
    ('SCG_9l0m1n2b3v4', 'MV_k3l4m5n6o7p8q', 'SC_b3c4d5e6f7g8h', '2024-06-17 15:20:00'),
    ('SCG_5c6v7z8x9a0', 'MV_r9s0t1u2v3w4x', 'SC_b3c4d5e6f7g8h', '2024-06-17 15:40:00'),
    ('SCG_2d3f4g5h6j7', 'MV_y5z6a7b8c9d0e', 'SC_b3c4d5e6f7g8h', '2024-06-17 16:00:00'),
    ('SCG_8k9l0m1n2b3', 'MV_f1g2h3i4j5k6l', 'SC_b3c4d5e6f7g8h', '2024-06-17 16:20:00');

INSERT INTO screening (id, movie_id, screen_id, timestamp)
VALUES
    ('SCG_1a2b3c4d5e9', 'MV_a1b2c3d4e5f', 'SC_b3c4d5e6f7g8h', '2024-06-18 12:00:00'),
    ('SCG_7f8g9h0i1j2', 'MV_g6h7i8j9k0lm', 'SC_b3c4d5e6f7g8h', '2024-06-18 12:20:00'),
    ('SCG_3k4l5m6n7o8', 'MV_n7o8p9q0r1s2t', 'SC_b3c4d5e6f7g8h', '2024-06-18 12:40:00'),
    ('SCG_9p0q1r2s3t4', 'MV_u2v3w4x5y6z7a', 'SC_b3c4d5e6f7g8h', '2024-06-18 13:00:00'),
    ('SCG_5u6v7w8x9y0', 'MV_b2c3d4e5f6g7h', 'SC_b3c4d5e6f7g8h', '2024-06-18 13:20:00'),
    ('SCG_2z3a4b5c6d7', 'MV_d8e9f0g1h2i3j', 'SC_b3c4d5e6f7g8h', '2024-06-18 13:40:00'),
    ('SCG_8e9f0g1h2i3', 'MV_k3l4m5n6o7p8q', 'SC_b3c4d5e6f7g8h', '2024-06-18 14:00:00'),
    ('SCG_4j5k6l7m8n9', 'MV_r9s0t1u2v3w4x', 'SC_b3c4d5e6f7g8h', '2024-06-18 14:20:00'),
    ('SCG_1o2p3q4r5s6', 'MV_y5z6a7b8c9d0e', 'SC_b3c4d5e6f7g8h', '2024-06-18 14:40:00'),
    ('SCG_7x8y9z0a1b2', 'MV_f1g2h3i4j5k6l', 'SC_b3c4d5e6f7g8h', '2024-06-18 15:00:00'),
    ('SCG_3c4d5e6f7g8', 'MV_a1b2c3d4e5f', 'SC_b3c4d5e6f7g8h', '2024-06-18 15:20:00'),
    ('SCG_9h0i1j2k3l4', 'MV_g6h7i8j9k0lm', 'SC_b3c4d5e6f7g8h', '2024-06-18 15:40:00'),
    ('SCG_5m6n7o8p9q0', 'MV_n7o8p9q0r1s2t', 'SC_b3c4d5e6f7g8h', '2024-06-18 16:00:00'),
    ('SCG_1r2s3t4u5v6', 'MV_u2v3w4x5y6z7a', 'SC_b3c4d5e6f7g8h', '2024-06-18 16:20:00'),
    ('SCG_7w8x9y0z1a2', 'MV_b2c3d4e5f6g7h', 'SC_b3c4d5e6f7g8h', '2024-06-18 16:40:00'),
    ('SCG_3a4b5c7d8e8', 'MV_d8e9f0g1h2i3j', 'SC_b3c4d5e6f7g8h', '2024-06-18 17:00:00'),
    ('SCG_9f0g1h1i5j4', 'MV_k3l4m5n6o7p8q', 'SC_b3c4d5e6f7g8h', '2024-06-18 17:20:00'),
    ('SCG_5k6l7m8n3ob', 'MV_r9s0t1u2v3w4x', 'SC_b3c4d5e6f7g8h', '2024-06-18 17:40:00'),
    ('SCG_1p2q3r4s5t6', 'MV_y5z6a7b8c9d0e', 'SC_b3c4d5e6f7g8h', '2024-06-18 18:00:00'),
    ('SCG_7u8v9w0x1g5', 'MV_f1g2h3i4j5k6l', 'SC_b3c4d5e6f7g8h', '2024-06-18 18:20:00'),
    ('SCG_3d4e5f6g7h8', 'MV_a1b2c3d4e5f', 'SC_b3c4d5e6f7g8h', '2024-06-18 18:40:00'),
    ('SCG_9i0j1k2l3m4', 'MV_g6h7i8j9k0lm', 'SC_b3c4d5e6f7g8h', '2024-06-18 19:00:00'),
    ('SCG_5n6o7p8q9r0', 'MV_n7o8p9q0r1s2t', 'SC_b3c4d5e6f7g8h', '2024-06-18 19:20:00'),
    ('SCG_1s2t3u4v5y7', 'MV_u2v3w4x5y6z7a', 'SC_b3c4d5e6f7g8h', '2024-06-18 19:40:00'),
    ('SCG_7x8y9z0a1c5', 'MV_b2c3d4e5f6g7h', 'SC_b3c4d5e6f7g8h', '2024-06-18 20:00:00');

INSERT INTO screening (id, movie_id, screen_id, timestamp)
VALUES
    ('SCG_1x2z3a4b5c6', 'MV_a1b2c3d4e5f', 'SC_b3c4d5e6f7g8h', '2024-06-19 12:00:00'),
    ('SCG_7d8e9f0g1h2', 'MV_g6h7i8j9k0lm', 'SC_b3c4d5e6f7g8h', '2024-06-19 12:20:00'),
    ('SCG_3i4j5k6l7m8', 'MV_n7o8p9q0r1s2t', 'SC_b3c4d5e6f7g8h', '2024-06-19 12:40:00'),
    ('SCG_9n0o1p2q3r4', 'MV_u2v3w4x5y6z7a', 'SC_b3c4d5e6f7g8h', '2024-06-19 13:00:00'),
    ('SCG_5s6t7u8v9w0', 'MV_b2c3d4e5f6g7h', 'SC_b3c4d5e6f7g8h', '2024-06-19 13:20:00'),
    ('SCG_2x3y4z5a6b7', 'MV_d8e9f0g1h2i3j', 'SC_b3c4d5e6f7g8h', '2024-06-19 13:40:00'),
    ('SCG_8c9d0e1f2g3', 'MV_k3l4m5n6o7p8q', 'SC_b3c4d5e6f7g8h', '2024-06-19 14:00:00'),
    ('SCG_4h5i6j7k8l9', 'MV_r9s0t1u2v3w4x', 'SC_b3c4d5e6f7g8h', '2024-06-19 14:20:00'),
    ('SCG_1m2n3o4p5q6', 'MV_y5z6a7b8c9d0e', 'SC_b3c4d5e6f7g8h', '2024-06-19 14:40:00'),
    ('SCG_7r8s9t0u1v2', 'MV_f1g2h3i4j5k6l', 'SC_b3c4d5e6f7g8h', '2024-06-19 15:00:00'),
    ('SCG_3w4x5y6z7a8', 'MV_a1b2c3d4e5f', 'SC_b3c4d5e6f7g8h', '2024-06-19 15:20:00'),
    ('SCG_9b0c1d2e3f4', 'MV_g6h7i8j9k0lm', 'SC_b3c4d5e6f7g8h', '2024-06-19 15:40:00'),
    ('SCG_5g6h7i8j9k0', 'MV_n7o8p9q0r1s2t', 'SC_b3c4d5e6f7g8h', '2024-06-19 16:00:00'),
    ('SCG_1l2m3n4o5p6', 'MV_u2v3w4x5y6z7a', 'SC_b3c4d5e6f7g8h', '2024-06-19 16:20:00'),
    ('SCG_7q8r9s0t1u2', 'MV_b2c3d4e5f6g7h', 'SC_b3c4d5e6f7g8h', '2024-06-19 16:40:00'),
    ('SCG_3v4w5x6y7z8', 'MV_d8e9f0g1h2i3j', 'SC_b3c4d5e6f7g8h', '2024-06-19 17:00:00'),
    ('SCG_9a0b1c2d3e4', 'MV_k3l4m5n6o7p8q', 'SC_b3c4d5e6f7g8h', '2024-06-19 17:20:00'),
    ('SCG_5f6g7h8i9j0', 'MV_r9s0t1u2v3w4x', 'SC_b3c4d5e6f7g8h', '2024-06-19 17:40:00'),
    ('SCG_1k2l3m4n5o6', 'MV_y5z6a7b8c9d0e', 'SC_b3c4d5e6f7g8h', '2024-06-19 18:00:00'),
    ('SCG_7p8q9r0s1t2', 'MV_f1g2h3i4j5k6l', 'SC_b3c4d5e6f7g8h', '2024-06-19 18:20:00'),
    ('SCG_3u4v5w6x7y8', 'MV_a1b2c3d4e5f', 'SC_b3c4d5e6f7g8h', '2024-06-19 18:40:00'),
    ('SCG_9z0a1b2c3d4', 'MV_g6h7i8j9k0lm', 'SC_b3c4d5e6f7g8h', '2024-06-19 19:00:00'),
    ('SCG_5e6f7g8h9i0', 'MV_n7o8p9q0r1s2t', 'SC_b3c4d5e6f7g8h', '2024-06-19 19:20:00'),
    ('SCG_1j2k3l4m5n6', 'MV_u2v3w4x5y6z7a', 'SC_b3c4d5e6f7g8h', '2024-06-19 19:40:00'),
    ('SCG_7o8p9q0r1s2', 'MV_b2c3d4e5f6g7h', 'SC_b3c4d5e6f7g8h', '2024-06-19 20:00:00');

INSERT INTO screening (id, movie_id, screen_id, timestamp)
VALUES
    ('SCG_1a2b3c4d5e7', 'MV_a1b2c3d4e5f', 'SC_b3c4d5e6f7g8h', '2024-06-20 12:00:00'),
    ('SCG_7f8g9h0i1j3', 'MV_g6h7i8j9k0lm', 'SC_b3c4d5e6f7g8h', '2024-06-20 12:20:00'),
    ('SCG_3k4l5m6n7o9', 'MV_n7o8p9q0r1s2t', 'SC_b3c4d5e6f7g8h', '2024-06-20 12:40:00'),
    ('SCG_9p0q1r2s3t5', 'MV_u2v3w4x5y6z7a', 'SC_b3c4d5e6f7g8h', '2024-06-20 13:00:00'),
    ('SCG_5u6v7w8x9y1', 'MV_b2c3d4e5f6g7h', 'SC_b3c4d5e6f7g8h', '2024-06-20 13:20:00'),
    ('SCG_2z3a4b5c6d8', 'MV_d8e9f0g1h2i3j', 'SC_b3c4d5e6f7g8h', '2024-06-20 13:40:00'),
    ('SCG_8e9f0g1h2i4', 'MV_k3l4m5n6o7p8q', 'SC_b3c4d5e6f7g8h', '2024-06-20 14:00:00'),
    ('SCG_4j5k6l7m8n0', 'MV_r9s0t1u2v3w4x', 'SC_b3c4d5e6f7g8h', '2024-06-20 14:20:00'),
    ('SCG_1o2p3q4r5s7', 'MV_y5z6a7b8c9d0e', 'SC_b3c4d5e6f7g8h', '2024-06-20 14:40:00'),
    ('SCG_7x8y9z0a1b3', 'MV_f1g2h3i4j5k6l', 'SC_b3c4d5e6f7g8h', '2024-06-20 15:00:00'),
    ('SCG_3c4d5e6f7g9', 'MV_a1b2c3d4e5f', 'SC_b3c4d5e6f7g8h', '2024-06-20 15:20:00'),
    ('SCG_9h0i1j2k3l5', 'MV_g6h7i8j9k0lm', 'SC_b3c4d5e6f7g8h', '2024-06-20 15:40:00'),
    ('SCG_5m6n7o8p9q1', 'MV_n7o8p9q0r1s2t', 'SC_b3c4d5e6f7g8h', '2024-06-20 16:00:00'),
    ('SCG_1r2s3t4u5v7', 'MV_u2v3w4x5y6z7a', 'SC_b3c4d5e6f7g8h', '2024-06-20 16:20:00'),
    ('SCG_7w8x9y0z1a3', 'MV_b2c3d4e5f6g7h', 'SC_b3c4d5e6f7g8h', '2024-06-20 16:40:00'),
    ('SCG_3a4b5c6d7e9', 'MV_d8e9f0g1h2i3j', 'SC_b3c4d5e6f7g8h', '2024-06-20 17:00:00'),
    ('SCG_9f0g1h2i3j5', 'MV_k3l4m5n6o7p8q', 'SC_b3c4d5e6f7g8h', '2024-06-20 17:20:00'),
    ('SCG_5k6l7m8n9o1', 'MV_r9s0t1u2v3w4x', 'SC_b3c4d5e6f7g8h', '2024-06-20 17:40:00'),
    ('SCG_1p2q3r4s5t7', 'MV_y5z6a7b8c9d0e', 'SC_b3c4d5e6f7g8h', '2024-06-20 18:00:00'),
    ('SCG_7u8v9w0x1y3', 'MV_f1g2h3i4j5k6l', 'SC_b3c4d5e6f7g8h', '2024-06-20 18:20:00'),
    ('SCG_3d4e5f6g7h9', 'MV_a1b2c3d4e5f', 'SC_b3c4d5e6f7g8h', '2024-06-20 18:40:00'),
    ('SCG_9i0j1k2l3m5', 'MV_g6h7i8j9k0lm', 'SC_b3c4d5e6f7g8h', '2024-06-20 19:00:00'),
    ('SCG_5n6o7p8q9r1', 'MV_n7o8p9q0r1s2t', 'SC_b3c4d5e6f7g8h', '2024-06-20 19:20:00'),
    ('SCG_1s2t3u4v5w7', 'MV_u2v3w4x5y6z7a', 'SC_b3c4d5e6f7g8h', '2024-06-20 19:40:00'),
    ('SCG_7x8y9z0a1b4', 'MV_b2c3d4e5f6g7h', 'SC_b3c4d5e6f7g8h', '2024-06-20 20:00:00');

INSERT INTO screening (id, movie_id, screen_id, timestamp)
VALUES
    ('SCG_1e2f3g4h5i6', 'MV_a1b2c3d4e5f', 'SC_b3c4d5e6f7g8h', '2024-06-21 12:00:00'),
    ('SCG_7j8k9l0m1n2', 'MV_g6h7i8j9k0lm', 'SC_b3c4d5e6f7g8h', '2024-06-21 12:20:00'),
    ('SCG_3o4p5q6r7s8', 'MV_n7o8p9q0r1s2t', 'SC_b3c4d5e6f7g8h', '2024-06-21 12:40:00'),
    ('SCG_9t0u1v2w3x4', 'MV_u2v3w4x5y6z7a', 'SC_b3c4d5e6f7g8h', '2024-06-21 13:00:00'),
    ('SCG_5y6z7a8b9c0', 'MV_b2c3d4e5f6g7h', 'SC_b3c4d5e6f7g8h', '2024-06-21 13:20:00'),
    ('SCG_2d3e4f5g6h7', 'MV_d8e9f0g1h2i3j', 'SC_b3c4d5e6f7g8h', '2024-06-21 13:40:00'),
    ('SCG_8i9j0k1l2m3', 'MV_k3l4m5n6o7p8q', 'SC_b3c4d5e6f7g8h', '2024-06-21 14:00:00'),
    ('SCG_4n5o6p7q8r9', 'MV_r9s0t1u2v3w4x', 'SC_b3c4d5e6f7g8h', '2024-06-21 14:20:00'),
    ('SCG_1s2t3u4v5w6', 'MV_y5z6a7b8c9d0e', 'SC_b3c4d5e6f7g8h', '2024-06-21 14:40:00'),
    ('SCG_7x8y9z0a1c4', 'MV_f1g2h3i4j5k6l', 'SC_b3c4d5e6f7g8h', '2024-06-21 15:00:00'),
    ('SCG_3c4d5e2j7g8', 'MV_a1b2c3d4e5f', 'SC_b3c4d5e6f7g8h', '2024-06-21 15:20:00'),
    ('SCG_9h0i1j2j5l4', 'MV_g6h7i8j9k0lm', 'SC_b3c4d5e6f7g8h', '2024-06-21 15:40:00'),
    ('SCG_5m6j8o8p9q0', 'MV_n7o8p9q0r1s2t', 'SC_b3c4d5e6f7g8h', '2024-06-21 16:00:00'),
    ('SCG_1r2s3t4u7g6', 'MV_u2v3w4x5y6z7a', 'SC_b3c4d5e6f7g8h', '2024-06-21 16:20:00'),
    ('SCG_7w8x9y0z3b2', 'MV_b2c3d4e5f6g7h', 'SC_b3c4d5e6f7g8h', '2024-06-21 16:40:00'),
    ('SCG_3a4b5c6d9j8', 'MV_d8e9f0g1h2i3j', 'SC_b3c4d5e6f7g8h', '2024-06-21 17:00:00'),
    ('SCG_9f0g3g2i3j4', 'MV_k3l4m5n6o7p8q', 'SC_b3c4d5e6f7g8h', '2024-06-21 17:20:00'),
    ('SCG_5k6l7a3n9o0', 'MV_r9s0t1u2v3w4x', 'SC_b3c4d5e6f7g8h', '2024-06-21 17:40:00'),
    ('SCG_1p2q3g9s5t6', 'MV_y5z6a7b8c9d0e', 'SC_b3c4d5e6f7g8h', '2024-06-21 18:00:00'),
    ('SCG_7u8v3z0x1y2', 'MV_f1g2h3i4j5k6l', 'SC_b3c4d5e6f7g8h', '2024-06-21 18:20:00'),
    ('SCG_3d4e3u6g7h8', 'MV_a1b2c3d4e5f', 'SC_b3c4d5e6f7g8h', '2024-06-21 18:40:00'),
    ('SCG_9i0j1a5l3m4', 'MV_g6h7i8j9k0lm', 'SC_b3c4d5e6f7g8h', '2024-06-21 19:00:00'),
    ('SCG_5n6o7i6q9r0', 'MV_n7o8p9q0r1s2t', 'SC_b3c4d5e6f7g8h', '2024-06-21 19:20:00'),
    ('SCG_1s2t3ujv5w7', 'MV_u2v3w4x5y6z7a', 'SC_b3c4d5e6f7g8h', '2024-06-21 19:40:00'),
    ('SCG_7x8yhz0a1b3', 'MV_b2c3d4e5f6g7h', 'SC_b3c4d5e6f7g8h', '2024-06-21 20:00:00');