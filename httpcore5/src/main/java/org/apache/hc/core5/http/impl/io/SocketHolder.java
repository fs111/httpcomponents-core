/*
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */

package org.apache.hc.core5.http.impl.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.apache.hc.core5.util.Args;

/**
 * Utility class that holds a {@link Socket} along with copies of its {@link InputStream} and {@link OutputStream}.
 *
 * @since 5.0
 */
public final class SocketHolder {

    private final Socket socket;
    private final InputStream inputStream;
    private final OutputStream outputStream;

    public SocketHolder(final Socket socket) throws IOException {
        this.socket = Args.notNull(socket, "Socket");
        this.inputStream = socket.getInputStream();
        this.outputStream = socket.getOutputStream();
    }

    public SocketHolder(final Socket socket, final InputStream inputStream, final OutputStream outputStream) throws IOException {
        this.socket = Args.notNull(socket, "Socket");
        this.inputStream = inputStream != null ? inputStream: socket.getInputStream();
        this.outputStream = outputStream != null ? outputStream : socket.getOutputStream();
    }

    public Socket getSocket() {
        return socket;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    @Override
    public String toString() {
        return socket.toString();
    }

}